package com.hw1.springboot3restapijpacrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hw1.springboot3restapijpacrud.*")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
