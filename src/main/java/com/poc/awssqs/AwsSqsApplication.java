package com.poc.awssqs;

import io.awspring.cloud.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.poc.*")
@SpringBootApplication(exclude = { ContextStackAutoConfiguration.class })
public class AwsSqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSqsApplication.class, args);
	}

}
