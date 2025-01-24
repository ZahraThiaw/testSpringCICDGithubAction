package sn.zahra.thiaw.testspringcicdgithubaction.Exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}