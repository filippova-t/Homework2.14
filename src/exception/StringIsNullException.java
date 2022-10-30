package exception;

public class StringIsNullException extends RuntimeException{
    public StringIsNullException() {
    }

    public StringIsNullException(String message) {
        super(message);
    }
}
