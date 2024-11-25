package patterns;

public class Decorator {

    // Step 1: The base component interface
    interface Notifier {
        String send(String message);
    }

    // Step 2: A concrete implementation of the Notifier interface
    static class SimpleNotifier implements Notifier {
        @Override
        public String send(String message) {
            return "Notification sent: " + message;
        }
    }

    // Step 3: The Decorator base class that also implements Notifier
    static class NotifierDecorator implements Notifier {
        protected Notifier notifier;  // Composition: holds a reference to a Notifier

        public NotifierDecorator(Notifier notifier) {
            this.notifier = notifier;
        }

        @Override
        public String send(String message) {
            // Delegates call to the notifier it wraps
            return notifier.send(message);
        }
    }

    // Step 4: Concrete decorators that add behavior
    static class SMSNotifier extends NotifierDecorator {
        public SMSNotifier(Notifier notifier) {
            super(notifier);
        }

        @Override
        public String send(String message) {
            // Adding SMS functionality to the notification
            return super.send(message) + " | SMS sent: " + message;
        }
    }

    static class EmailNotifier extends NotifierDecorator {
        public EmailNotifier(Notifier notifier) {
            super(notifier);
        }

        @Override
        public String send(String message) {
            // Adding Email functionality to the notification
            return super.send(message) + " | Email sent: " + message;
        }
    }
}
