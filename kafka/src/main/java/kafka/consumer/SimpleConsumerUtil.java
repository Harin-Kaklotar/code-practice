package kafka.consumer;

import java.nio.ByteBuffer;
import java.util.*;

import kafka.api.PartitionFetchInfo;
import kafka.api.PartitionOffsetRequestInfo;
import kafka.cluster.BrokerEndPoint;
import kafka.common.ErrorMapping;
import kafka.common.TopicAndPartition;
import kafka.javaapi.*;
import kafka.javaapi.consumer.SimpleConsumer;
import kafka.message.MessageAndOffset;

public class SimpleConsumerUtil {
    public static void main(String args[]) {
        SimpleConsumerUtil example = new SimpleConsumerUtil();
        /**
         1. Maximum number of messages to read (so we don’t loop forever)
         2. Topic to read from
         3. Partition to read from
         4. One broker to use for Metadata lookup
         5. Port the brokers listen on
         */
        /*long maxReads = Long.parseLong(args[0]);
        String topic = args[1];
        int partition = Integer.parseInt(args[2]);
        List<String> seeds = new ArrayList<String>();
        seeds.add(args[3]);
        int port = Integer.parseInt(args[4]);*/

        long maxReads = 5;
        String topic = "cloudphotosws";
        int partition = 1;
        List<String> seeds = new ArrayList<String>();
        seeds.add("vp21q01if-tydh18021601.vp.if1.apple.com");
        int port = 9092;
        try {
            //example.run(maxReads, topic, partition, seeds, port);

            example.readMessagesInOffsetRange(seeds,port,"rio",0,32720,32722);
        } catch (Exception e) {
            System.out.println("Oops:" + e);
            e.printStackTrace();
        }
    }


    private List<String> m_replicaBrokers = new ArrayList<String>();

    public SimpleConsumerUtil() {
        m_replicaBrokers = new ArrayList<String>();
    }

    public static long getLastOffset(SimpleConsumer consumer, String topic, int partition,
        long whichTime, String clientName) {
        TopicAndPartition topicAndPartition = new TopicAndPartition(topic, partition);
        Map<TopicAndPartition, PartitionOffsetRequestInfo> requestInfo = new HashMap<TopicAndPartition, PartitionOffsetRequestInfo>();
        requestInfo.put(topicAndPartition, new PartitionOffsetRequestInfo(whichTime, 1));
        kafka.javaapi.OffsetRequest request = new kafka.javaapi.OffsetRequest(
            requestInfo, kafka.api.OffsetRequest.CurrentVersion(), clientName);
        OffsetResponse response = consumer.getOffsetsBefore(request);

        if (response.hasError()) {
            System.out.println("Error fetching data Offset Data the Broker. Reason: " + response.errorCode(topic, partition) );
            return 0;
        }
        long[] offsets = response.offsets(topic, partition);
        return offsets[0];
    }

    private String findNewLeader(String a_oldLeader, String a_topic, int a_partition, int a_port) throws Exception {
        for (int i = 0; i < 3; i++) {
            boolean goToSleep = false;
            PartitionMetadata metadata = findLeader(m_replicaBrokers, a_port, a_topic, a_partition);
            if (metadata == null) {
                goToSleep = true;
            } else if (metadata.leader() == null) {
                goToSleep = true;
            } else if (a_oldLeader.equalsIgnoreCase(metadata.leader().host()) && i == 0) {
                // first time through if the leader hasn't changed give ZooKeeper a second to recover
                // second time, assume the broker did recover before failover, or it was a non-Broker issue
                //
                goToSleep = true;
            } else {
                return metadata.leader().host();
            }
            if (goToSleep) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                }
            }
        }
        System.out.println("Unable to find new leader after Broker failure. Exiting");
        throw new Exception("Unable to find new leader after Broker failure. Exiting");
    }

    /**
     * Find the leader for the topic-partition
     * @param a_seedBrokers
     * @param a_port
     * @param a_topic
     * @param a_partition
     * @return
     */
    private PartitionMetadata findLeader(List<String> a_seedBrokers, int a_port, String a_topic, int a_partition) {
        PartitionMetadata returnMetaData = null;
        loop:
        for (String seed : a_seedBrokers) {
            SimpleConsumer consumer = null;
            try {
                consumer = new SimpleConsumer(seed, a_port, 100000, 64 * 1024, "leaderLookup");
                List<String> topics = Collections.singletonList(a_topic);
                TopicMetadataRequest req = new TopicMetadataRequest(topics);
                kafka.javaapi.TopicMetadataResponse resp = consumer.send(req);

                List<TopicMetadata> metaData = resp.topicsMetadata();
                for (TopicMetadata item : metaData) {
                    for (PartitionMetadata part : item.partitionsMetadata()) {
                        if (part.partitionId() == a_partition) {
                            returnMetaData = part;
                            break loop;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error communicating with Broker [" + seed + "] to find Leader for [" + a_topic
                    + ", " + a_partition + "] Reason: " + e);
            } finally {
                if (consumer != null) consumer.close();
            }
        }
        if (returnMetaData != null) {
            m_replicaBrokers.clear();
            for (BrokerEndPoint brokerEndPoint : returnMetaData.replicas()) {
                m_replicaBrokers.add(brokerEndPoint.host());
            }
        }
        return returnMetaData;
    }

    /**
     * Wrapper method to fetch limited n messages for a topic partition
     * @param a_maxReads
     * @param a_topic
     * @param a_partition
     * @param a_seedBrokers
     * @param a_port
     * @throws Exception
     */
    public void run(long a_maxReads, String a_topic, int a_partition, List<String> a_seedBrokers, int a_port) throws Exception {
        // find the meta data about the topic and partition we are interested in
        //
        PartitionMetadata metadata = findLeader(a_seedBrokers, a_port, a_topic, a_partition);
        if (metadata == null) {
            System.out.println("Can't find metadata for Topic and Partition. Exiting");
            return;
        }
        if (metadata.leader() == null) {
            System.out.println("Can't find Leader for Topic and Partition. Exiting");
            return;
        }
        String leadBroker = metadata.leader().host();
        String clientName = "Client_" + a_topic + "_" + a_partition;

        SimpleConsumer consumer = new SimpleConsumer(leadBroker, a_port, 100000, 64 * 1024, clientName);
        long readOffset = getLastOffset(consumer,a_topic, a_partition, kafka.api.OffsetRequest.EarliestTime(), clientName);

        int numErrors = 0;
        while (a_maxReads > 0) {
            if (consumer == null) {
                consumer = new SimpleConsumer(leadBroker, a_port, 100000, 64 * 1024, clientName);
            }

            TopicAndPartition topicAndPartition = new TopicAndPartition(a_topic, a_partition);
            //log.info("Asking time for offset : " + (currentOffset));
            PartitionFetchInfo partitionFetchInfo = new PartitionFetchInfo(readOffset, 1024*1024*5);

            HashMap<TopicAndPartition, PartitionFetchInfo> fetchInfo = new HashMap<TopicAndPartition, PartitionFetchInfo>();
            fetchInfo.put(topicAndPartition, partitionFetchInfo);


            FetchRequest req = new FetchRequest(new Random().nextInt(),clientName,10000,1,fetchInfo);

            /*FetchRequest req = new FetchRequestBuilder()
                .clientId(clientName)
                .addFetch(a_topic, a_partition, readOffset, 100000) // Note: this fetchSize of 100000 might need to be increased if large batches are written to Kafka
                .build();*/
            FetchResponse fetchResponse = consumer.fetch(req);

            if (fetchResponse.hasError()) {
                numErrors++;
                // Something went wrong!
                short code = fetchResponse.errorCode(a_topic, a_partition);
                System.out.println("Error fetching data from the Broker:" + leadBroker + " Reason: " + code);
                if (numErrors > 5) break;
                if (code == ErrorMapping.OffsetOutOfRangeCode())  {
                    // We asked for an invalid offset. For simple case ask for the last element to reset
                    readOffset = getLastOffset(consumer,a_topic, a_partition, kafka.api.OffsetRequest.LatestTime(), clientName);
                    continue;
                }
                consumer.close();
                consumer = null;
                leadBroker = findNewLeader(leadBroker, a_topic, a_partition, a_port);
                continue;
            }
            numErrors = 0;

            long numRead = 0;
            for (MessageAndOffset messageAndOffset : fetchResponse.messageSet(a_topic, a_partition)) {
                long currentOffset = messageAndOffset.offset();
                if (currentOffset < readOffset) {
                    System.out.println("Found an old offset: " + currentOffset + " Expecting: " + readOffset);
                    continue;
                }
                readOffset = messageAndOffset.nextOffset();
                ByteBuffer payload = messageAndOffset.message().payload();

                byte[] bytes = new byte[payload.limit()];
                payload.get(bytes);
                System.out.println(String.valueOf(messageAndOffset.offset()) + ": " + new String(bytes, "UTF-8"));
                numRead++;
                a_maxReads--;
            }

            if (numRead == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                }
            }
        }
        if (consumer != null) consumer.close();
    }



    /**
     * Wrapper method to fetch messages in offset range
     * @param a_seedBrokers
     * @param a_port
     * @param a_topic
     * @param a_partition
     * @param startOffset
     * @param endOffset
     * @throws Exception
     */
    public void readMessagesInOffsetRange(List<String> a_seedBrokers, int a_port,String a_topic, int a_partition,int startOffset,int endOffset)
    throws  Exception{
        PartitionMetadata metadata = findLeader(a_seedBrokers, a_port, a_topic, a_partition);
        if (metadata == null) {
            System.out.println("Can't find metadata for Topic and Partition. Exiting");
            return;
        }
        if (metadata.leader() == null) {
            System.out.println("Can't find Leader for Topic and Partition. Exiting");
            return;
        }
        String leadBroker = metadata.leader().host();
        String clientName = "Client_" + a_topic + "_" + a_partition;

        SimpleConsumer consumer = new SimpleConsumer(leadBroker, a_port, 100000, 64 * 1024, clientName);
        outerLoop:
        for (long i = startOffset; i < endOffset ; i++) {
                if (consumer==null){
                    consumer = new SimpleConsumer(leadBroker, a_port, 100000, 64 * 1024, clientName);
                }

                TopicAndPartition topicAndPartition = new TopicAndPartition(a_topic, a_partition);
                //log.info("Asking time for offset : " + (currentOffset));
                PartitionFetchInfo partitionFetchInfo = new PartitionFetchInfo(startOffset, 1024*1024*5);

                HashMap<TopicAndPartition, PartitionFetchInfo> fetchInfo = new HashMap<TopicAndPartition, PartitionFetchInfo>();
                fetchInfo.put(topicAndPartition, partitionFetchInfo);

                FetchRequest req = new FetchRequest(new Random().nextInt(),clientName,10000,1,fetchInfo);

                FetchResponse fetchResponse = consumer.fetch(req);

                if (fetchResponse.hasError()) {
                    // Something went wrong!
                    short code = fetchResponse.errorCode(a_topic, a_partition);
                    System.out.println("Error fetching data from the Broker:" + leadBroker + " Reason: " + code);
                    if (code == ErrorMapping.OffsetOutOfRangeCode())  {
                        continue;
                    }
                    consumer.close();
                    consumer = null;
                    leadBroker = findNewLeader(leadBroker, a_topic, a_partition, a_port);
                    continue;
                }

                for (MessageAndOffset messageAndOffset : fetchResponse.messageSet(a_topic, a_partition)) {
                    long currentOffset = messageAndOffset.offset();

                    ByteBuffer payload = messageAndOffset.message().payload();

                    byte[] bytes = new byte[payload.limit()];
                    payload.get(bytes);
                    System.out.println(String.valueOf(messageAndOffset.offset()) + ": " + new String(bytes, "UTF-8"));

                    i= currentOffset;
                    if(currentOffset>=endOffset){
                        break outerLoop; //already fetched requested messages .. break now
                    }
                }
            }

        if (consumer != null) consumer.close();

    }
}