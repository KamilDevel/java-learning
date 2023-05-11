package com.gizmo.reactor.application.http.config;

import com.gizmo.reactor.lib.SecondLib;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondLibConfig {
    @Value("${spring.secondLib.param1}")
    private String param1;

    @Value("${spring.secondLib.param2}")
    private String param2;

    @Value("${spring.secondLib.param3}")
    private String param3;

    @Bean
    public SecondLib secondLib() {
        return new SecondLib(param1, param2, param3);
    }
}
