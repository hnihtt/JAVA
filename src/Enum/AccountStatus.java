package Enum;

// Code demo Enum cơ bản
public enum AccountStatus {
    INACTIVE(0, "Không hoạt động"),
    ACTIVE(1, "Đang hoạt động"),
    SUSPENDED(2, "Bị khóa"),
    WAITING_TO_BE_APPROVED(3, "Chờ xác minh");

    private final int statusCode;
    private final String desc;

//    Constructor của Enum luôn private
    AccountStatus(int statusCode, String desc) {
        this.statusCode = statusCode;
        this.desc = desc;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getDesc() {
        return desc;
    }
}

/*
enum Color {
    RED, GREEN, BLUE
}
------------------------------
final class Color extends Enum<Color> {
    public static final Color RED = new Color("RED", 0);
    public static final Color GREEN = new Color("GREEN", 1);
    public static final Color BLUE = new Color("BLUE", 2);
}
 */
