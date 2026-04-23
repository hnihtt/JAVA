package TryCatchNFiles.Ex3;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException() {
        super();
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
