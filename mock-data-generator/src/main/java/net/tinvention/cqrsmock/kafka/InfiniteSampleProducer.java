package net.tinvention.cqrsmock.kafka;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.tinvention.cqrsmock.manager.RandomSampleGenerator;
import net.tinvention.cqrsmock.model.MeasureId;
import net.tinvention.cqrsmock.model.Sample;

/**
 * A producer that simply sends randomly generated measure samples
 * @author mlegnani
 */
@Service
public class InfiniteSampleProducer extends SampleProducerTemplate {

  @Inject
  private ObjectMapper objectMapper;

  @Inject
  private RandomSampleGenerator randomSampleGenerator;

  @Override
  protected void generateData(Producer<String, String> producer, HashMap<MeasureId, Sample> lastSamplesMap) throws InterruptedException, JsonProcessingException {
    while (true) {
      Sample model = randomSampleGenerator.generateSample(lastSamplesMap);
      lastSamplesMap.put(model.getSource(), model);

      producer.send(new ProducerRecord<String, String>(samplesTopic, "key", objectMapper.writeValueAsString(model)));

      if (sleep > 0) {
        Thread.sleep(sleep);
      }
    }

  }
}
