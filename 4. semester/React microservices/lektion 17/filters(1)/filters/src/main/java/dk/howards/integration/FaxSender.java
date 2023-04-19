package dk.howards.integration;

import dk.howards.domain.Message;

public class FaxSender implements MessageSender {

    @Override
    public void sendMessage(Message message) {
        System.out.println("SEND FAX");
    }
}
