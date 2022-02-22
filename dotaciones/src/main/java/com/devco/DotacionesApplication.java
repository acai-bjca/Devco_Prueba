package com.devco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ConfigurationProperties
@PropertySource(value = { "file:/apiRest.properties" })
public class DotacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DotacionesApplication.class, args);
	}

}
