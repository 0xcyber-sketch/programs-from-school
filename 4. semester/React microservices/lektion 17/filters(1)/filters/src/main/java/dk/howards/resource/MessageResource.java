package dk.howards.resource;

import dk.howards.domain.Message;
import dk.howards.domain.MessageContent;
import dk.howards.domain.Receiver;
import dk.howards.domain.Sender;
import dk.howards.resource.dto.MessageDTO;
import dk.howards.service.MessageService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/messages")
@RequestScoped
public class MessageResource {
    private final MessageService service;

    @Inject
    public MessageResource(MessageService service) {
        this.service = service;
    }

    @POST
    public Response sendMessage(MessageDTO message) {
        service.sendMessage(new Message(new Sender(message.getSender()), new Receiver(message.getReceiver()), new MessageContent(message.getMessage())));
        return Response.status(Response.Status.OK).build();
    }
}
