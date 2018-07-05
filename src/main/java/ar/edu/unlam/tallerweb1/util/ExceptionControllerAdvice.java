package ar.edu.unlam.tallerweb1.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionBody> illegalArgumentException(IllegalArgumentException iae){
        ExceptionBody exceptionBody = new ExceptionBody(HttpStatus.BAD_REQUEST.value(), iae.getMessage());
        ResponseEntity<ExceptionBody> respuesta = new ResponseEntity(exceptionBody, HttpStatus.BAD_REQUEST);
        return respuesta;
    }
}
