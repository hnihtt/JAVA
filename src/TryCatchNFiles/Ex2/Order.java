package TryCatchNFiles.Ex2;

public class Order {
    private final int id;
    private String product;
    private Integer quant;
    private double price;


    public Order(Builder builder) {
        this.id = builder.id;
        this.product = builder.product;
        this.quant = builder.quant;
        this.price = builder.price;
    }

    @Override
    public String toString() {
        return "id:" + id + " " + "product:" + product + " " + "quant:" + quant + " " + "price:" + price;
    }

    public static class Builder {
        private int id;
        private String product;
        private Integer quant;
        private double price;

        Builder() {}

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder product(String product) {
            this.product = product;
            return this;
        }

        public Builder quant(Integer quant) {
            this.quant = quant;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
