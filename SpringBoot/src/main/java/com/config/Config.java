package com.config;

import com.service.A;
import com.service.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@ComponentScan(value = "com.controller", lazyInit = true)
public class Config {

    @Bean
    @DependsOn("ClassB")
    public A a() {
        return new A();
    }

    @Bean(name = "ClassB")
    public B b() {
        return new B();
    }
}

/*

@ComponentScan (value=)
value is alias for basePackages

 */