public class MyApplication {
    public static void main(String[] args) {
        String message = "Hello, Dependency Injection!";
        String emailRecipient = "email@example.com";
        String smsRecipient = "123-456-7890";

        MessageServiceInjector injector;
        Consumer consumer;

        // Enviar un mensaje por correo electrónico
        injector = new EmailServiceInjector();
        consumer = injector.getConsumer();
        consumer.processMessages(message, emailRecipient);

        // Enviar un mensaje por SMS
        injector = new SMSServiceInjector();
        consumer = injector.getConsumer();
        consumer.processMessages(message, smsRecipient);
    }
}
