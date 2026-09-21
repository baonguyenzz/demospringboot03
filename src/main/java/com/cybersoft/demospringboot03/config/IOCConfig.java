package com.cybersoft.demospringboot03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.cybersoft.demospringboot03.entity.Student;

@Configuration // Đánh dấu class này là một class config
public class IOCConfig {
    @Bean
    @Primary // Đánh dấu bean này là bean chính
    public Student getStudent() {
        return new Student("cybersoft", 5);
    }
}
