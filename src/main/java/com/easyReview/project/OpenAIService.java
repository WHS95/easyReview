package com.easyReview.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class OpenAIService {

    private final WebClient webClient;

    @Autowired
    public OpenAIService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> generateText(String message) {
        return webClient.post()
                .uri("/chat/completions")
                .contentType(MediaType.APPLICATION_JSON)  // Content-Type 헤더 설정
                .bodyValue(new ChatRequest("gpt-3.5-turbo", List.of(new Message("user", message))))
                .retrieve()
                .bodyToMono(String.class);
    }

    private static class ChatRequest {
        private final String model;
        private final List<Message> messages;

        public ChatRequest(String model, List<Message> messages) {
            this.model = model;
            this.messages = messages;
        }

        public String getModel() {
            return model;
        }

        public List<Message> getMessages() {
            return messages;
        }
    }

    private static class Message {
        private final String role;
        private final String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }

        public String getRole() {
            return role;
        }

        public String getContent() {
            return content;
        }
    }
}
