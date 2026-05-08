package Stream.Test;

import java.time.LocalDateTime;

public class UserParseException extends Exception{
    LocalDateTime timestamp;

    public UserParseException(String message, LocalDateTime timestamp) {
        super(message);
        this.timestamp = timestamp;
    }

    public UserParseException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " " + timestamp;
    }
}
