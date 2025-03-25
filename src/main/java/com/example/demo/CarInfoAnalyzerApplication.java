package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.demo")
public class CarInfoAnalyzerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarInfoAnalyzerApplication.class, args);
    }
}