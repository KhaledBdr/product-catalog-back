package com.fawry.productcatalog.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DurationDTO {
    private LocalDate start;
    private LocalDate end;
}
