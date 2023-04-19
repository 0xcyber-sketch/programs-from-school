package dk.howards.integration;

import io.vertx.core.http.HttpServerRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class MessageSenderProducer {

    @Inject
    HttpServerRequest request;

    @Produces
    @RequestScoped
    public MessageSender createMessageSender() {
        String senderType = request.headers().get("sender-type");
        if (senderType.equals("sms")) {
            return new SMSSender();
        } else if (senderType.equals("fax")) {
            return new FaxSender();
        } else {
            return new MailSender();
        }
    }
}
