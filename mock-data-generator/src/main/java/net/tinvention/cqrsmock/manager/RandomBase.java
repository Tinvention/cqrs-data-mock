package net.tinvention.cqrsmock.manager;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RandomBase {

  Logger log = LoggerFactory.getLogger(this.getClass());

  Random random = new Random();

  public <T> T pickOne(T[] array) {
    int x = random.nextInt(array.length);
    return array[x];
  }

  public <T> T pickOne(T[] array, T... exclude) {
    T[] newArray = ArrayUtils.removeElements(array, exclude);
    return pickOne(newArray);
  }

  public <T extends Enum<?>> T rEnum(T[] constants) {
    return pickOne(constants);
  }

  public <T extends Enum<?>> T rEnum(Class<T> clazz) {
    return rEnum(clazz.getEnumConstants());
  }

  public <T extends Enum<?>> T rEnum(Class<T> clazz, T... exclude) {
    T[] constants = ArrayUtils.removeElements(clazz.getEnumConstants(), exclude);
    return rEnum(constants);
  }

  public Integer rInt() {
    return random.nextInt();
  }

  public Integer rInt(int max) {
    return random.nextInt(max);
  }

  public Long rLong() {
    return random.nextLong();
  }

  public Long rLong(long max) {
    // max bound must be positive and greater than 0
    return ThreadLocalRandom.current().nextLong(max);
  }

  /**
   * Random date in the past
   * @param msMax: how back in time from now the random date can be (in ms)
   * @return date in ms
   */
  public Long rDatePast(long msMax) {
    Date date = new Date();
    return date.getTime() - rLong(msMax);
  }

  public Long rDateFuture(long msMax) {
    Date date = new Date();
    return date.getTime() + rLong(msMax);
  }

  public Boolean rBool() {
    return random.nextBoolean();
  }
  
  public Boolean rBool(double probTrue) {
    return random.nextDouble() < probTrue;
  }

  public Double rDouble() {
    return random.nextDouble();
  }

  public float rFloat() {
    return random.nextFloat();
  }

  public Double rDouble(double max) {
    return ThreadLocalRandom.current().nextDouble(max);
  }

}
