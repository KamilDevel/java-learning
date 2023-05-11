package com.gizmo.reactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication()
@EnableFeignClients(basePackages = {"com.gizmo.reactor.infrastructure.http.repository"})
public class ReactorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReactorApplication.class, args);
    }
}