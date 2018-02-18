package com;

import com.config.Config;
import com.config.Config1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import({Config1.class,Config.class})
public class App
{
    public static void main( String[] args )
    {


    	SpringApplication.run(App.class, args);
    	
    }
}

/*
To import classes in specified order then just import Configuration classes without @Configuration annotation

The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes:



 */