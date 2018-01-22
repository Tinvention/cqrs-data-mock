package net.tinvention.cqrsmock.manager;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Ignore;
import org.junit.Test;

import net.tinvention.cqrsmock.utils.BaseTest;

public class ManualKafkaProducerTest extends BaseTest {

  @Test
  @Ignore
  public void manuallyProduce() throws Exception {
    Properties properties = new Properties();
    properties.put("bootstrap.servers", "127.0.0.1:9092");
    properties.put("client.id", "SampleProducer");
    properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
    properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    KafkaProducer producer = new KafkaProducer<>(properties);
    String topic = "cqrs-mock-plant";
    boolean isAsync = false;

    int messageNo = 1;
    while (true) {
      String messageStr = "Message_" + messageNo;
      long startTime = System.currentTimeMillis();
      if (isAsync) { // Send asynchronously
        // producer.send(new ProducerRecord&lt;&gt;(topic,
        // messageNo,
        // messageStr), new DemoCallBack(startTime, messageNo, messageStr));
      } else { // Send synchronously
        try {
          producer.send(new ProducerRecord<>(topic, messageNo, messageStr)).get();
          System.out.println("Sent message: (" + messageNo + ", " + messageStr + ")");
        } catch (InterruptedException | ExecutionException e) {
          e.printStackTrace();
          // handle the exception
        }
      }
      ++messageNo;
    }
  }
}
