package patterns;
/**
 * Strategy Pattern demonstration for a payment processing system.
 * <p>
 * The Strategy Pattern allows us to define a family of algorithms (payment methods),
 * encapsulate them in separate classes, and make them interchangeable at runtime.
 */
interface PaymentStrategy {
    /**
     * Processes a payment of the specified amount.
     *
     * @param amount the amount to be paid
     */
    void pay(Double amount);
}

/**
 * A context class that processes payments using a specific strategy.
 * The strategy is selected dynamically at runtime.
 */
public class Strategy {

    /**
     * Processes a payment using the specified payment strategy.
     * @param strategy the payment strategy to use
     * @param amount amount the amount to be paid
     */
    public static void processPayment(PaymentStrategy strategy, double amount) {
        strategy.pay(amount);
    }
}
/**
 * Concrete strategy for PayPal payments.
 * Implements the {@link PaymentStrategy} interface to process payments using PayPal.
 */
class PayPalPayment implements PaymentStrategy{
    @Override
    public void pay(Double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}
/**
 * Concrete strategy for Credit Card payments.
 * Implements the {@link PaymentStrategy} interface to process payments using a Credit Card.
 */
class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(Double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}


