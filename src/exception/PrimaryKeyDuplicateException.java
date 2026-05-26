package exception;

public class PrimaryKeyDuplicateException extends Exception {
    public PrimaryKeyDuplicateException(String message) {
        super(message);
    }
}
