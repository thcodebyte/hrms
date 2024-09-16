package com.hrms.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {
        "com.hrms", "com.hrms.attendance", "com.hrms.account"
})
@EntityScan(basePackages = {"com.hrms.common.domain.entity"})
@EnableJpaRepositories(basePackages = {"com.hrms"})
@EnableJpaAuditing
@EnableTransactionManagement
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        System.out.println("HRMS running..");
    }
}
