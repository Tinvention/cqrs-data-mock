package net.tinvention.cqrsmock.kafka;

import org.springframework.beans.factory.annotation.Value;

public class BaseClient {

  @Value("${kafka.samples.topic}")
  protected String samplesTopic;

  @Value("${servers}")
  protected String servers;

  @Value("${producer.sleep.ms}")
  protected int sleep;

}
