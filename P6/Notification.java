@FunctionalInterface
interface Notifier {
    void send(String message);
}

interface Urgent {
}

class EmailSender implements Notifier, Urgent {
    public void send(String message) {
        System.out.println("EMAIL: " + message);
    }
}

class SMSSender implements Notifier {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

public class Notification {
    public static void main(String[] args) {

        Notifier email = new EmailSender();
        Notifier sms = new SMSSender();

        Notifier[] notifiers = {email, sms};

        String message = "Exam starts at 9 AM";

        for (Notifier notifier : notifiers) {

            notifier.send(message);

            if (notifier instanceof Urgent) {
                notifier.send(message);
            }
        }
    }
}