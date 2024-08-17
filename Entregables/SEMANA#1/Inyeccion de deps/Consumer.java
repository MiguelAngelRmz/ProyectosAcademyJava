public class Consumer {
    private MessageService service;

    public Consumer(MessageService service) {
        this.service = service;
    }

    public void processMessages(String message, String recipient) {
        service.sendMessage(message, recipient);
    }
}
