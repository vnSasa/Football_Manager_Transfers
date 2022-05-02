package ua.yaremechko.footballmanager.validation.exceptions.team;

public class TeamNameException extends RuntimeException {

    public TeamNameException() {
    }

    public TeamNameException(String message) {
        super(message);
    }
}
