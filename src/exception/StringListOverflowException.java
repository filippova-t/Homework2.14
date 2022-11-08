package exception;

public class StringListOverflowException extends RuntimeException{
    public StringListOverflowException() {
    }

    public StringListOverflowException(String message) {
        super(message);
    }
}
