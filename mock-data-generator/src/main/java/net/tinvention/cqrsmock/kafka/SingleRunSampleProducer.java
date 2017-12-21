package net.tinvention.cqrsmock.kafka;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.tinvention.cqrsmock.manager.RandomSampleGenerator;
import net.tinvention.cqrsmock.model.MeasureId;
import net.tinvention.cqrsmock.model.Sample;

// produces a set of ${singlerun.numitems} random messages with increasing ids.
@Service
public class SingleRunSampleProducer extends SampleProducerTemplate {

  @Value("${singlerun.numitems:100}")
  private int numitems;

  @Inject
  private RandomSampleGenerator randomSampleGenerator;

  @Inject
  private ObjectMapper objectMapper;

  @Override
  protected void generateData(Producer<String, String> producer, HashMap<MeasureId, Sample> lastSamplesMap) throws InterruptedException, JsonProcessingException {
    for (int count = 0; count < numitems; count++) {
      Sample model = randomSampleGenerator.generateSample(lastSamplesMap);
      lastSamplesMap.put(model.getSource(), model);

      producer.send(new ProducerRecord<String, String>(samplesTopic, "key", objectMapper.writeValueAsString(model)));

      if (sleep > 0) {
        Thread.sleep(sleep);
      }
    }
  }
}
