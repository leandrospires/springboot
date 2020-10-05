package com.example.websocketdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class WebsocketApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources(WebsocketApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WebsocketApplication.class, args);
	}

}
