package com.d5assignment3506.localmessagingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.d5assignment3506.localmessagingsystem.repo")
public class LocalMessagingSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocalMessagingSystemApplication.class, args);
    }
}
