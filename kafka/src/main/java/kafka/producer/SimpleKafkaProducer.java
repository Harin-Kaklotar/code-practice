package kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class SimpleKafkaProducer {

    KafkaProducer<String, String> producer;

    SimpleKafkaProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9090");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("sasl.jaas.config","org.apache.kafka.common.security.plain.PlainLoginModule required username=\"alice\" password=\"alice-secret\"");
        props.put("security.protocol","SASL_PLAINTEXT");
        props.put("sasl.mechanism","PLAIN");
        producer = new KafkaProducer<>(props);
    }

    public void sendWithoutCallback(String topic, String key, String value) {

        producer.send(new ProducerRecord<>(topic, key, value));
    }

    public void sendWithCallback(String topic, String key, String value) {
        producer.send(new ProducerRecord<String, String>(topic, key, value), new Callback() {
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception == null) {
                    System.out.println(String.format("offset %d,partition %d", metadata.offset(),metadata.partition()));
                } else {
                    exception.printStackTrace();
                }
            }
        });
    }

    public void close() {
        producer.close();
    }


    public static void main(String[] args) {
        SimpleKafkaProducer simpleKafkaProducer = null;
        try {
            simpleKafkaProducer = new SimpleKafkaProducer();
            for (int i = 0; i < 100; i++) {
                simpleKafkaProducer.sendWithoutCallback("test",Integer.toString(i),Integer.toString(i));
            }

            for (int i = 0; i < 100; i++) {
                simpleKafkaProducer.sendWithCallback("test", Integer.toString(i), Integer.toString(i));
            }
            //give sometime for callback
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            simpleKafkaProducer.close();
        }
    }
}
