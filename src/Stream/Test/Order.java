package Stream.Test;

public class Order {
    private String id;
    private String name;
    private OrderStatus status;
    private double amount;
    private String location;

    public Order(String id, String name, OrderStatus status, double amount, String location) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.amount = amount;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", amount=" + amount +
                ", location='" + location + '\'' +
                '}';
    }
}
