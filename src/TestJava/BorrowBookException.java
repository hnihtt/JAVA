package TestJava;

public class BorrowBookException extends Exception{
    public BorrowBookException() {
        super();
    }

    public BorrowBookException(String message) {
        super(message);
    }

    public BorrowBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public BorrowBookException(Throwable cause) {
        super(cause);
    }
}
