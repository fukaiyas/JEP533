package jep533;

public class TransformFailedException extends Exception {
    public TransformFailedException(String message) {
        super(message);
    }
    public TransformFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
