import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.Properties;
import java.util.Arrays;

public class Consumer implements Runnable {

    Properties props = new Properties();
    KafkaConsumer<String, String> consumer;
    ClientUi Cui;

    public Consumer(ClientUi client, String nickName){
        this.props.put("bootstrap.servers", "localhost:9092");
        this.props.put("group.id", nickName);
        this.props.put("enable.auto.commit", "true");
        this.props.put("auto.offset.reset", "latest");
        this.props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        this.props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        this.consumer = new KafkaConsumer<String, String>(this.props);
        consumer.subscribe(Arrays.asList("chatting2"));

        this. Cui = client;
    }
    @Override

    public void run(){

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(0);
            for (ConsumerRecord<String, String> record : records) {
                String s = record.topic();
                if ("chatting2".equals(s)) {
                    Cui.ta.append(record.value() + "\n");
                } else {
                    throw new IllegalStateException("get message on topic " + record.topic());
                }
            }
        }

    }
}
