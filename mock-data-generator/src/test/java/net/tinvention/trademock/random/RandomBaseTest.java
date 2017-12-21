package net.tinvention.trademock.random;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import net.tinvention.cqrsmock.manager.RandomBase;
import net.tinvention.cqrsmock.model.MeasureId;
import net.tinvention.trademock.model.TestEnum;
import net.tinvention.trademock.utils.BaseTest;

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

}
