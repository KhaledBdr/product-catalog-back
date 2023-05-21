package com.fawry.productcatalog.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductPriceDTO {
    @NotNull(message = "Id " +" {validation.required}")
    private Long id;
    @Min(value = 1 , message ="{validation.price}")
    @NotNull(message = "Price "+" {validation.required}")
    private double price;
}
