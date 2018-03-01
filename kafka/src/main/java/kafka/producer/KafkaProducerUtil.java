package kafka.producer;

import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * Created by liju on 4/6/16.
 */
public class KafkaProducerUtil {
    private final KafkaProducer kafkaProducer;

    public KafkaProducerUtil(Properties properties){
        kafkaProducer = new KafkaProducer(properties);
    }

    public void send(ProducerRecord producerRecord){
        kafkaProducer.send(producerRecord,new ProducerCallback());
    }
    public void close(){
        kafkaProducer.close();
    }

    class ProducerCallback implements Callback {
        @Override public void onCompletion(RecordMetadata metadata, Exception exception) {
            if (exception !=null){
                exception.printStackTrace();
            }else{
                System.out.println("event sent : topic - "+metadata.topic() +" , partition  - "+metadata.partition()+" , offset - "+metadata.offset());
            }
        }
    }


    public static void main(String[] args) {
        try {
            InputStream inputStream = KafkaProducerUtil.class.getClassLoader().getResourceAsStream("producer.properties");
            if (inputStream==null ){
                System.out.println("producer properties not found .. exiting");
                return;
            }
            Properties producerProp = new Properties();
            producerProp.load(inputStream);

            KafkaProducerUtil kafkaProducerUtil = new KafkaProducerUtil(producerProp);

            //load eventdata  props
            Properties eventDataProp = new Properties();
            eventDataProp.load(KafkaProducerUtil.class.getClassLoader().getResourceAsStream("eventdata.properties"));

            //load utility props
            Properties eventdataKeys = new Properties();
            eventdataKeys.load(KafkaProducerUtil.class.getClassLoader().getResourceAsStream("eventdataKeys.properties"));
            final Set<Object> keys = eventdataKeys.keySet();

            int msgCount = Integer.valueOf(eventDataProp.getProperty("default.msgCount"));
            String topicName = eventDataProp.getProperty("default.topic");

            for (Object key : keys) {
                final String eventData = eventDataProp.getProperty((String) key);
                if (eventDataProp.getProperty(key + ".msgCount")!=null)
                    msgCount = Integer.valueOf(eventDataProp.getProperty(key + ".msgCount"));
                if (eventDataProp.getProperty(key + ".topic")!=null)
                    topicName = eventDataProp.getProperty(key + ".topic") ;

                for (int i = 0; i < msgCount; i++) {
                    System.out.println("sending message");
                    kafkaProducerUtil.send(new ProducerRecord(topicName,eventData.getBytes()));
                }

            }

            kafkaProducerUtil.close();

            Thread.sleep(20000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

