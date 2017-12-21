package net.tinvention.cqrsmock.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import net.tinvention.cqrsmock.kafka.InfiniteSampleProducer;
import net.tinvention.cqrsmock.manager.RandomBase;
import net.tinvention.cqrsmock.restcontroller.GlobalControllerAdvice;

@Configuration
@ComponentScan(basePackageClasses = { RandomBase.class, InfiniteSampleProducer.class })
@Import(GlobalControllerAdvice.class)
public class AppConfig {

}
