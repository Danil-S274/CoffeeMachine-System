package src;

public class PaymentSystem {

    public boolean processPayment(double paid, double cost) {
        if (paid >= cost) {
            double change = paid - cost;
            if (change > 0) {
                System.out.printf("Returning change: $%.2f%n", change);
            }
            return true;
        } else {
            System.out.println("Insufficient payment.");
            return false;
        }
    }

    public void refund(double amount) {
        System.out.printf("Refunding $%.2f%n", amount);
    }
}
