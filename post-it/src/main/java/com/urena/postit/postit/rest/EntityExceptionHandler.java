package com.urena.postit.postit.rest;

import com.urena.postit.postit.exceptions.PostNotFoundException;
import com.urena.postit.postit.exceptions.UserNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class EntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception exception, WebRequest request){
        return new ResponseEntity<>(
                new ExceptionResponse(new Date(),exception.getMessage(),request.getDescription(false)),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException exception, WebRequest request){
        return new ResponseEntity<>(
                new ExceptionResponse(new Date(),exception.getMessage(),request.getDescription(false)),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handlePostNotFoundException(PostNotFoundException exception, WebRequest request){
        return new ResponseEntity<>(
                new ExceptionResponse(new Date(),exception.getMessage(),request.getDescription(false)),
                HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(
                new ExceptionResponse(new Date(),"Validation failed",
                        exception.getBindingResult().getAllErrors().stream()
                                                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                                    .reduce("Causes: ",this::concatErrors)
                                                    .replace(" , "," ")),
                HttpStatus.BAD_REQUEST);
    }

    private String concatErrors(String s1, String s2) {
        return s1 + ", " + s2;
    }
}
