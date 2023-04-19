package dk.howards.service;

import dk.howards.domain.Message;
import dk.howards.integration.MessageSender;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class MessageService {

    private MessageSender messageSender;

    @Inject
    public MessageService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(Message message) {
        messageSender.sendMessage(message);
    }
}
