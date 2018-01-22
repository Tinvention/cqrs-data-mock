package net.tinvention.cqrsmock.utils;

import org.junit.Assert;
import org.junit.Test;

import net.tinvention.cqrsmock.manager.Utils;

public class UtilsTest extends BaseTest {

  @Test
  public void formatDate() throws Exception {

    String date = Utils.format(1479291082049L, "yyyyMMdd");

    Assert.assertEquals("20161116", date);

  }

}
