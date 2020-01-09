import org.apache.kafka.clients.producer.KafkaProducer;
import java.util.Properties;

public class Producer {

    Properties configs = new Properties();
    KafkaProducer <String, String> producer;

    public Producer(){

        this.configs.put("bootstrap.servers", "localhost:9092"); // kafka host 및 server 설정
        this.configs.put("acks", "all");                         // 자신이 보낸 메시지에 대해 카프카로부터 확인을 기다리지 않습니다.
        this.configs.put("block.on.buffer.full", "true");        // 서버로 보낼 레코드를 버퍼링 할 때 사용할 수 있는 전체 메모리의 바이트수
        this.configs.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");   // serialize 설정
        this.configs.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); // serialize 설정

        this.producer = new KafkaProducer<String, String>(configs);
    }
}
