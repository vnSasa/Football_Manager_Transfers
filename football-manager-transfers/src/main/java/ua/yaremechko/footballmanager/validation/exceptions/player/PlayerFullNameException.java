package ua.yaremechko.footballmanager.validation.exceptions.player;

public class PlayerFullNameException extends RuntimeException {

    public PlayerFullNameException() {
    }

    public PlayerFullNameException(String message) {
        super(message);
    }
}
