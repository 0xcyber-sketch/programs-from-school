package dk.howards.domain;

public class Message {
    private final Sender sender;
    private final Receiver receiver;
    private final MessageContent content;

    public Message(Sender sender, Receiver receiver, MessageContent content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public Sender getSender() {
        return sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public MessageContent getContent() {
        return content;
    }
}
