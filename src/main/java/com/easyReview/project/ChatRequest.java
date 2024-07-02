package com.easyReview.project;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChatRequest {
    private final String model;
    private final List<Message> messages;

    public ChatRequest(String model, List<Message> messages) {
        this.model = model;
        this.messages = messages;
    }

    @JsonProperty
    public String getModel() {
        return model;
    }

    @JsonProperty
    public List<Message> getMessages() {
        return messages;
    }
}

