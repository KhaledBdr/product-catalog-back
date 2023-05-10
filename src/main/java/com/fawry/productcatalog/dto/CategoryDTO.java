package com.fawry.productcatalog.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
@Data
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    @NotNull(message = "Category name " + "{validation.required}")
    @Length(min = 2 , message ="{validation.name.length}")
    private String name;

    private String description;
}
