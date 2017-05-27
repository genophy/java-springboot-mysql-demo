package com.eno.project.mysqldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.eno.project.mysqldemo.repository")
@SpringBootApplication
public class MysqlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlDemoApplication.class, args);
    }
}
