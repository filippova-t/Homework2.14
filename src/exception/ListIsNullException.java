package exception;

public class ListIsNullException extends RuntimeException{
    public ListIsNullException() {
    }

    public ListIsNullException(String message) {
        super(message);
    }
}
