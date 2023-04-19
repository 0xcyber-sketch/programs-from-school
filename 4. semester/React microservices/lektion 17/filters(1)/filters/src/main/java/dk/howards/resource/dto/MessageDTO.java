package dk.howards.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDTO {
    private final String sender;
    private final String receiver;
    private final String message;

    @JsonCreator
    public MessageDTO(@JsonProperty("sender") String sender, @JsonProperty("receiver") String receiver, @JsonProperty("message") String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }
}
