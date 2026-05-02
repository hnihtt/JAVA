package Stream.MorePracticing;

public class Order {
    private double amount;
    private boolean isPaid;

    public Order(double amount, boolean isPaid) {
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return isPaid;
    }
}
