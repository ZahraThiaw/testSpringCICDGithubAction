package sn.zahra.thiaw.testspringcicdgithubaction.Exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}