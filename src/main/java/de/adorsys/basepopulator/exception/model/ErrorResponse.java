package de.adorsys.basepopulator.exception.model;

import java.util.List;

public class ErrorResponse {

    private List<String> messages;

    public ErrorResponse() {
    }

    public ErrorResponse(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
