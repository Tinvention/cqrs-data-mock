package net.tinvention.cqrsmock.model;

/**
 * Identifiers for the mock measures to be generated
 * @author mlegnani
 *
 */
public enum MeasureId {
  IN_VOLTAGE(0.5d), IN_CURRENT(0.5d), LOT_CHANGE(0.01d), ITEM_CHANGE(0.02d), PRESSURE_KJYTD25ZAA(0.5d), TEMPERATURE_HDVAM78(0.5d);
  
  // probability of the event to occur
  private final double prob;

  private MeasureId(double probReduce) {
    this.prob = probReduce;
  }

  public double getProb() {
    return prob;
  }
  
}
