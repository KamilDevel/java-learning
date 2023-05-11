package com.gizmo.reactor.application.http.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReactorListener {
    @KafkaListener(topics = "${spring.kafka.reactor-topic}", groupId = "${spring.kafka.group-id}")
    public void listen(String message) {
        log.warn("Received Message: " + message);
    }
}
