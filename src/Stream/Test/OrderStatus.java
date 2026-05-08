package Stream.Test;

public enum OrderStatus {
    COMPLETED(1, "Hoàn thành"),
    PENDING(-1, "Đang chờ"),
    CANCELLED(0, "Đã hủy");

    private final int statusCode;
    private final String des;

    OrderStatus(int statusCode, String des) {
        this.statusCode = statusCode;
        this.des = des;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getDes() {
        return des;
    }
}
