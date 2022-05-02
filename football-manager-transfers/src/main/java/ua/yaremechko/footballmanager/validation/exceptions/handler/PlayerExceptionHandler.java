package ua.yaremechko.footballmanager.validation.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ua.yaremechko.footballmanager.validation.exceptions.player.PlayerAgeException;
import ua.yaremechko.footballmanager.validation.exceptions.player.PlayerFullNameException;
import ua.yaremechko.footballmanager.validation.exceptions.player.PlayerMonthOfExperienceException;
import ua.yaremechko.footballmanager.validation.exceptions.player.PlayerNotFoundException;

@ControllerAdvice
public class PlayerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PlayerAgeException.class)
    public ResponseEntity<ErrorMessage> handleException(PlayerAgeException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PlayerFullNameException.class)
    public ResponseEntity<ErrorMessage> handleException(PlayerFullNameException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(PlayerMonthOfExperienceException.class)
    public ResponseEntity<ErrorMessage> handleException(PlayerMonthOfExperienceException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleException(PlayerNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
