package com.example.prova_tech4music.view.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationHandles extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        // TODO Auto-generated method stub
       List<FieldError> erros = 
        ex.
        getBindingResult().
        getFieldErrors();

        List<String> mensagens = new ArrayList<>();

        for (FieldError fe : erros) {
            mensagens.add(fe.getDefaultMessage());
        }

        return new ResponseEntity<Object>(mensagens, HttpStatus.OK);
    }

}
   


