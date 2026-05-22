package TestJava;

public class BorrowLimitException extends Exception {
    public BorrowLimitException(Throwable cause) {
        super(cause);
    }

    public BorrowLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public BorrowLimitException(String message) {
        super(message);
    }

    public BorrowLimitException() {
        super();
    }
}
