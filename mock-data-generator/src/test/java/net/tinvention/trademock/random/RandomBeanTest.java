package net.tinvention.trademock.random;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import net.tinvention.trademock.model.TestBean;
import net.tinvention.trademock.utils.BaseTest;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class RandomBeanTest extends BaseTest{
  

  
  @Ignore
  @Test
  public void generateRandomTestBean(){

    PodamFactory factory = new PodamFactoryImpl();
    
    TestBean test = factory.manufacturePojo(TestBean.class);
    
    Assert.assertNotNull(test.getString());
    Assert.assertNotNull(test.getInteger());
    Assert.assertNotNull(test.getNested().getString());
  }

  
  

}
