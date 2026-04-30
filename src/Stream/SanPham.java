package Stream;

public class SanPham {
    private String product;
    private String category;
    private double price;
    private int stock;

    public SanPham(String product, String category, double price, int stock) {
        this.product = product;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "product='" + product + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
