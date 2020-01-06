package my.com.seleniumsample.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("my.com.seleniumsample.test")
@PropertySource("classpath:application.properties")
public class TestConfig {
}
