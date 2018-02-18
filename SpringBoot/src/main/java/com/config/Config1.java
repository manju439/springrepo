package com.config;

import com.service.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {

    @Bean
    public B b() {
        return new B();
    }
}
