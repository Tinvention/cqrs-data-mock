package net.tinvention.cqrsmock.manager;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import net.tinvention.cqrsmock.model.MeasureId;
import net.tinvention.cqrsmock.model.Sample;

@Service
public class RandomSampleGenerator extends RandomBase {

  public Sample generateSample(HashMap<MeasureId, Sample> lastSamplesMap) {
    Assert.notNull(lastSamplesMap, "lastSamplesMap argument is required");
    
    Sample result = new Sample();

    MeasureId measureId = rEnum(MeasureId.class);
    Sample prevSample = lastSamplesMap.get(measureId);

    float baseValue = 0;
    if (prevSample != null) {
      baseValue = prevSample.getValue();
    }
    
    if (rBool(measureId.getProb())) {
      result.setValue(baseValue + rFloat() * (rBool() ? 1 : -1));
      result.setTimestamp(new Date());
      result.setSource(measureId);
  
      return result;
    }
    // discard sample an generate another one
    return generateSample(lastSamplesMap);
  }
}
