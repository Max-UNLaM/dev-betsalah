package ar.edu.unlam.tallerweb1.util;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentException(){

    }

}
