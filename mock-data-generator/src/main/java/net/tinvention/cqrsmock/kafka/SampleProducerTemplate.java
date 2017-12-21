package net.tinvention.cqrsmock.kafka;

import java.util.HashMap;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.tinvention.cqrsmock.model.MeasureId;
import net.tinvention.cqrsmock.model.Sample;

/**
 * Template method abstract class for all the different types of sample producers.<br>
 * Can be better generalized using generic types instead of Sample and MeasureId 
 * 
 * @author mlegnani
 */
@Service
public abstract class SampleProducerTemplate extends BaseProducer {

  public void run() {
    log.debug("Sample Producer started.");

    Properties props = getProperties();
    props.put("value.serializer", StringSerializer.class.getName());
    Producer<String, String> producer = new KafkaProducer<>(props);
    HashMap<MeasureId, Sample> lastSamplesMap = new HashMap<>();

    try {

      generateData(producer, lastSamplesMap);

    } catch (Exception e) {
      log.debug("", e);
    } finally {
      if (producer != null) {
        producer.close();
      }
    }
  }

  protected abstract void generateData(Producer<String, String> producer, HashMap<MeasureId, Sample> lastSamplesMap) throws InterruptedException, JsonProcessingException;

}