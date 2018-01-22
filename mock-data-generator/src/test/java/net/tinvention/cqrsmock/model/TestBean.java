package net.tinvention.cqrsmock.model;

public class TestBean {
  
  private String string;
  
  private int integer;
  
  private TestBeanNested nested; 

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  public int getInteger() {
    return integer;
  }

  public void setInteger(int integer) {
    this.integer = integer;
  }

  public TestBeanNested getNested() {
    return nested;
  }

  public void setNested(TestBeanNested nested) {
    this.nested = nested;
  }
  
  
  
  

}
