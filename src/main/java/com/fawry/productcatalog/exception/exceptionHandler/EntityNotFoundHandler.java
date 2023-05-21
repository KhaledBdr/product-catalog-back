package com.fawry.productcatalog.exception.exceptionHandler;

import com.fawry.productcatalog.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
@RequiredArgsConstructor
public class EntityNotFoundHandler {
    private final MessageSource messageSource;
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleNotFoundEntity(EntityNotFoundException exception) {
        ErrorResponse response = new ErrorResponse(
                messageSource.getMessage("entity.notFound" , null, LocaleContextHolder.getLocale()) ,
                Arrays.asList(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
