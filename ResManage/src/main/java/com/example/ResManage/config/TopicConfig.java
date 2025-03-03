package com.example.ResManage.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

public class TopicConfig {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer addCustomDateFormat() {
        return builder -> builder.modules(new JavaTimeModule());
    }
}
