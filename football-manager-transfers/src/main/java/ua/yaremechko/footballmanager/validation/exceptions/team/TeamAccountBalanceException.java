package ua.yaremechko.footballmanager.validation.exceptions.team;

public class TeamAccountBalanceException extends RuntimeException {
    public TeamAccountBalanceException() {
    }

    public TeamAccountBalanceException(String message) {
        super(message);
    }
}
