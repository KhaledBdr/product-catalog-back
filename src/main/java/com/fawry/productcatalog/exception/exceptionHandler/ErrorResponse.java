package com.fawry.productcatalog.exception.exceptionHandler;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorResponse {

    private Boolean success;
    private String message;
    private LocalDateTime localDateTime;
    private List<String> details;

    public ErrorResponse(String message, List<String> details) {
        this.success = false;
        this.message = message;
        this.localDateTime = LocalDateTime.now();
        this.details = details;
    }
}
