package ua.yaremechko.footballmanager.validation.exceptions.player;

public class PlayerAgeException extends RuntimeException {
    public PlayerAgeException() {
    }

    public PlayerAgeException(String message) {
        super(message);
    }
}
