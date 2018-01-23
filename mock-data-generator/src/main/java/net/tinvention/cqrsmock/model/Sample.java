package net.tinvention.cqrsmock.model;

import java.util.Date;

public class Sample {

  private MeasureId source;
  private Date timestamp;
  private float value;

  public MeasureId getSource() {
    return source;
  }

  public void setSource(MeasureId source) {
    this.source = source;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public float getValue() {
    return value;
  }

  public void setValue(float value) {
    this.value = value;
  }
}
