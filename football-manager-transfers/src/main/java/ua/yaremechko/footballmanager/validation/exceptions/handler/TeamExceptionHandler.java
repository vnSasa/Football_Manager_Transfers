package ua.yaremechko.footballmanager.validation.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ua.yaremechko.footballmanager.validation.exceptions.team.TeamAccountBalanceException;
import ua.yaremechko.footballmanager.validation.exceptions.team.TeamCountryException;
import ua.yaremechko.footballmanager.validation.exceptions.team.TeamNameException;
import ua.yaremechko.footballmanager.validation.exceptions.team.TeamNotFoundException;
import ua.yaremechko.footballmanager.validation.exceptions.team.TeamTransferTaxException;

@ControllerAdvice
public class TeamExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleException(TeamNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TeamAccountBalanceException.class)
    public ResponseEntity<ErrorMessage> handleException(TeamAccountBalanceException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(TeamCountryException.class)
    public ResponseEntity<ErrorMessage> handleException(TeamCountryException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(TeamNameException.class)
    public ResponseEntity<ErrorMessage> handleException(TeamNameException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TeamTransferTaxException.class)
    public ResponseEntity<ErrorMessage> handleException(TeamTransferTaxException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
