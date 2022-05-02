package ua.yaremechko.footballmanager.validation.exceptions.team;

public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException() {
    }

    public TeamNotFoundException(String message) {
        super(message);
    }

    public TeamNotFoundException(Throwable cause) {
        super(cause);
    }
}
