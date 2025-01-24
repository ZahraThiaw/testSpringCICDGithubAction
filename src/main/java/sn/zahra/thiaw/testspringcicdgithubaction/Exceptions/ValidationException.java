package sn.zahra.thiaw.testspringcicdgithubaction.Exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
