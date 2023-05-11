package com.gizmo.reactor.application.http.config;

import com.gizmo.reactor.lib.FirstLib;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirstLibConfig {
    @Value("${spring.firstLib.param1}")
    private String param1;

    @Value("${spring.firstLib.param2}")
    private String param2;

    @Bean
    public FirstLib firstLib() {
        return new FirstLib(param1, param2);
    }
}
