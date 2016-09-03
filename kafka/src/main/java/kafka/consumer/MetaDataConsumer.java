package kafka.consumer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kafka.javaapi.TopicMetadataRequest;
import kafka.javaapi.TopicMetadataResponse;
import kafka.javaapi.consumer.SimpleConsumer;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;

public class MetaDataConsumer {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MetaDataConsumer.class);
    private ZooKeeper zk;
    private final JSONParser jsonParser = new JSONParser();

    public MetaDataConsumer(ZooKeeper zk) {
        this.zk = zk;
    }

    public TopicMetadataResponse getMetaDataResponse(final String topic, final String brokerId) throws KeeperException, InterruptedException, ParseException {

        final List<String> brokerList = zk.getChildren("", false);
        if (!brokerList.contains(brokerId)) {
            throw new IllegalArgumentException("Broker Id " + brokerId + " is not registered with zookeeper");
        }

        final TopicMetadataResponse topicMetadataResponse;
        SimpleConsumer simpleConsumer = null;
        try {
            byte[] brokerInfo = zk.getData("/brokers/ids/" + brokerId, false, null);
            final JSONObject jsonObject = (JSONObject) jsonParser.parse(new String(brokerInfo));
            String brokerHost = (String) jsonObject.get("host");
            Long port = (Long) jsonObject.get("port");

            simpleConsumer = new SimpleConsumer(brokerHost, port.intValue(), 30000, 64 * 1024, "Utility");

            List<String> topicList = new ArrayList<String>();
            topicList.add(topic);

            final TopicMetadataRequest topicMetadataRequest = new TopicMetadataRequest(topicList);
            topicMetadataResponse = simpleConsumer.send(topicMetadataRequest);

            if(topicMetadataResponse != null)
            logger.info(topicMetadataResponse.toString());
        } finally {
            if(simpleConsumer!=null){
                simpleConsumer.close();
            }
        }

        return topicMetadataResponse;
    }

    public static void main(String[] args) {
        try {
            ZooKeeper zk = new ZooKeeper("", 1000, new MetadataWatcher(), false);
            MetaDataConsumer metaDataConsumer = new MetaDataConsumer(zk);

            System.out.println(zk.getChildren("/brokers/ids", false));
            System.out.println(new String(zk.getData("/brokers/ids/11", false, null)));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

}

