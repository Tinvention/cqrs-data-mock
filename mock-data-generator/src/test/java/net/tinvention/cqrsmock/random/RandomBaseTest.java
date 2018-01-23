package net.tinvention.cqrsmock.random;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import net.tinvention.cqrsmock.manager.RandomBase;
import net.tinvention.cqrsmock.model.MeasureId;
import net.tinvention.cqrsmock.model.TestEnum;
import net.tinvention.cqrsmock.utils.BaseTest;

public class RandomBaseTest extends BaseTest {

  @Autowired
  @Qualifier("randomBase")
  private RandomBase random;

  @Test
  public void RandomEnum() throws Exception {

    MeasureId st = random.rEnum(MeasureId.class);

    Assert.assertNotNull(st);
  }

  @Test
  public void RandomEnumExclude() throws Exception {

    TestEnum test = random.rEnum(TestEnum.class, TestEnum.ONE);

    Assert.assertNotEquals(TestEnum.ONE, test);

  }

  @Test
  public void RandomInt() throws Exception {
    Assert.assertNotNull(random.rInt());
  }

  @Test
  public void RandomLong() throws Exception {
    Assert.assertNotNull(random.rLong());
  }

  @Test
  public void RandomLongMax() throws Exception {
    long num = random.rLong(1);
    Assert.assertNotNull(num);
    Assert.assertTrue(num < 1);
  }

  @Test
  @Ignore
  public void RandomBoolWProb() throws Exception {
    int totCount = 1000;
    int countTrue = 0;
    int countFalse = 0;
    double trueProb = 0.1;
    for (int i = 0; i < totCount; i++) {
      if (random.rBool(trueProb)) {
        countTrue++;
      } else {
        countFalse++;
      }
    }
    Assert.assertEquals(totCount, countTrue + countFalse);
    Assert.assertTrue(countTrue>0);
    Assert.assertTrue(countFalse>0);
    Assert.assertEquals(trueProb, (double)countTrue / countFalse, 0.05);
  }

}
