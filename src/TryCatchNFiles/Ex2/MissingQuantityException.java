package TryCatchNFiles.Ex2;

public class MissingQuantityException extends RuntimeException{
    public MissingQuantityException(String message) {
        super(message);
    }
    public MissingQuantityException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingQuantityException(Throwable cause) {
        super(cause);
    }
}
