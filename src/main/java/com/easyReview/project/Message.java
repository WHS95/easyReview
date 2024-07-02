package com.easyReview.project;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    private final String role;
    private final String content;

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    @JsonProperty
    public String getRole() {
        return role;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
