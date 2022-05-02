package ua.yaremechko.footballmanager.validation.exceptions.team;

public class TeamCountryException extends RuntimeException {

    public TeamCountryException() {
    }

    public TeamCountryException(String message) {
        super(message);
    }
}
