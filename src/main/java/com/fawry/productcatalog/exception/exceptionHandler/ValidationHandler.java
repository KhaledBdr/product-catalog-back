package com.fawry.productcatalog.exception.exceptionHandler;

import com.fawry.productcatalog.exception.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class ValidationHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity validationErrorHandler (MethodArgumentNotValidException exception) {
        ErrorResponse response = new ErrorResponse(exception.getFieldError().getDefaultMessage(),
                Arrays.asList(exception.getLocalizedMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
