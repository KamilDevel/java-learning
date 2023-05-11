package com.gizmo.reactor.application.http.config;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiServiceConfig {
    @Value("${spring.openAI.token}")
    private String token;

    @Bean
    public OpenAiService OpenAiService() {
        return new OpenAiService(token);
    }
}
