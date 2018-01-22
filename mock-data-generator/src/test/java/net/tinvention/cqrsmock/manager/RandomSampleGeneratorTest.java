package net.tinvention.cqrsmock.manager;

import java.util.HashMap;

import javax.inject.Inject;

import org.junit.Test;

import org.junit.Assert;
import net.tinvention.cqrsmock.manager.RandomSampleGenerator;
import net.tinvention.cqrsmock.model.MeasureId;
import net.tinvention.cqrsmock.model.Sample;
import net.tinvention.cqrsmock.utils.BaseTest;

public class RandomSampleGeneratorTest extends BaseTest {

  @Inject
  private RandomSampleGenerator randomSampleGenerator;

  @Test
  public void generateWithEmptyMap() throws Exception {
    HashMap<MeasureId, Sample> lastSamplesMap = new HashMap<>();

    Sample generatedSample = randomSampleGenerator.generateSample(lastSamplesMap);

    Assert.assertNotNull(generatedSample);
  }
  
  @Test
  public void generateFillingMap() throws Exception {
    HashMap<MeasureId, Sample> lastSamplesMap = new HashMap<>();

    Sample firstSample = randomSampleGenerator.generateSample(lastSamplesMap);
    Assert.assertNotNull(firstSample);
    
    lastSamplesMap.put(firstSample.getSource(), firstSample);
    
    Sample generatedSample = null;
    while(generatedSample == null || lastSamplesMap.get(generatedSample.getSource()) != null) {
      generatedSample = randomSampleGenerator.generateSample(lastSamplesMap);
    }
    // sample of the same source generated: should be a different instance
    Assert.assertFalse(generatedSample == firstSample);    
  }
}
