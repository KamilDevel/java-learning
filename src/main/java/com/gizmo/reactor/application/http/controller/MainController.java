package com.gizmo.reactor.application.http.controller;

import com.gizmo.reactor.infrastructure.http.repository.RestGoogleRepository;
import com.gizmo.reactor.lib.FirstLib;
import com.gizmo.reactor.lib.SecondLib;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = MainController.MAIN_ENDPOINT)
public class MainController {
    public static final String MAIN_ENDPOINT = "/api";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final RestGoogleRepository googleRepository;

    private final FirstLib firstLib;
    private final SecondLib secondLib;
    private final OpenAiService service;

    @GetMapping
    public String index() {
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "what is the name of president Duda");
        messages.add(systemMessage);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .n(1)
                .maxTokens(50)
                .logitBias(new HashMap<>())
                .build();

        service.streamChatCompletion(chatCompletionRequest)
                .doOnError(Throwable::printStackTrace)
                .blockingForEach(System.out::println);

//        log.info("index");
//        kafkaTemplate.send("reactor-inbound", "This is kafka message for pen Duda");
        return "test";
    }

    @GetMapping("/first-lib")
    public String firstLib() {
        return firstLib.toString();
    }

    @GetMapping("/second-lib")
    public String secondLib() {
        return secondLib.toString();
    }
}
