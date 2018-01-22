package net.tinvention.cqrsmock.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseProducer extends BaseClient {

  Logger log = LoggerFactory.getLogger(this.getClass());

  public Properties getProperties() {

//    props.put("batch.size", 16384);
//    props.put("linger.ms", 1);
//    props.put("buffer.memory", 33554432);

//    props.put("bootstrap.servers", "127.0.0.1:9092");    
//    props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
//    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    
    Properties props = new Properties();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
    props.put(ProducerConfig.CLIENT_ID_CONFIG, "SampleProducer");
    props.put(ProducerConfig.ACKS_CONFIG, "all");
    props.put(ProducerConfig.RETRIES_CONFIG, 0);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");    
    
    return props;
  }

}
