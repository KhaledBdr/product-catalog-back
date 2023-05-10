package com.fawry.productcatalog.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductQuantityDTO {

     private Long id;

        @NotNull(message = "Quantity " + "{ validation.required}")
        @Min(value = 0 , message ="{validation.quantity}")
        private int quantity;
    }
