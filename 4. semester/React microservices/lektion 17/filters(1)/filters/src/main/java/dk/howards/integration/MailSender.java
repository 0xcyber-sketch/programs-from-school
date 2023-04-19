package dk.howards.integration;

import dk.howards.domain.Message;

public class MailSender implements MessageSender {

    @Override
    public void sendMessage(Message message) {
        System.out.println("SEND MAIL");
    }
}
