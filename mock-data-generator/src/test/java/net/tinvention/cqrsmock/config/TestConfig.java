package net.tinvention.cqrsmock.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import net.tinvention.cqrsmock.kafka.AppSelector;
import net.tinvention.cqrsmock.manager.RandomBase;

@Configuration
@ComponentScan(basePackageClasses = { RandomBase.class, AppSelector.class })
public class TestConfig {

}
