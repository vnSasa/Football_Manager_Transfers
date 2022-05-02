package ua.yaremechko.footballmanager.validation.exceptions.player;

public class PlayerNotFoundException extends  RuntimeException{
    public PlayerNotFoundException() {
    }

    public PlayerNotFoundException(String message) {
        super(message);
    }
}
