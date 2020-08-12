package com.sontan.myb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"com.sontan"})

public class EmpApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmpApplication.class, args);
    }
}
