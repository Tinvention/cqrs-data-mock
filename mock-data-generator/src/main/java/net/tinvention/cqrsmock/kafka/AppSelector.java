package net.tinvention.cqrsmock.kafka;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import net.tinvention.cqrsmock.config.AppConfig;

@SpringBootApplication
@Import(AppConfig.class)
public class AppSelector implements CommandLineRunner {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Value("${main}")
  private String select;

  @Inject
  private InfiniteSampleProducer infiniteSampleProducer;

  @Inject
  private SingleRunSampleProducer singleRunSampleProducer;

  public static void main(String[] args) {
    SpringApplication.run(AppSelector.class, args);
  }

  @Override
  public void run(String... arg0) throws Exception {
    switch (select) {
    case "InfiniteSampleProducer":
      infiniteSampleProducer.run();
      break;
    case "SingleRunSampleProducer":
      singleRunSampleProducer.run();
      break;

    default:
      log.debug("Selector not found. Value is: " + select + ". Select which app to run, edit 'main' property");
    }
  }
}
