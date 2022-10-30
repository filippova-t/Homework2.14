package exception;

public class IllegalIndexException extends RuntimeException{
    public IllegalIndexException() {
    }

    public IllegalIndexException(String message) {
        super(message);
    }
}
