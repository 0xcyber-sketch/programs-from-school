package dk.howards.integration;

import dk.howards.domain.Message;

public interface MessageSender {
    void sendMessage(Message message);
}
