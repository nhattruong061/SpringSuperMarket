package com.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringMyContactApplication extends SpringBootServletInitializer {
	
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringMyContactApplication.class);
	}
	
	public static void main(String[] args){
		try{
			SpringApplication.run(SpringMyContactApplication.class, args);
		}catch (Throwable t) {
            System.err.println(t.getMessage());
        }
	}
}