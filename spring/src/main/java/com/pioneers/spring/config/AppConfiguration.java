package com.pioneers.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(Student.class)
@Configuration
public class AppConfiguration {
    /*@Value("${student.name}")
    private String studentName;
    @Value("${student.age}")
    private int studentAge;
    @Value("${student.email}")
    private String studentEmail;*/

/*    @Bean
    public Student student(){
        return new Student(studentName,studentAge,studentEmail);
    }*/

    @Bean
    public Student2 student(){
        return new Student2();
    }
}
