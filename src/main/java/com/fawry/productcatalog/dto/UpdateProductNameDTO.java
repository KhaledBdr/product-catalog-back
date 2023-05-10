package com.fawry.productcatalog.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductNameDTO {
    @NotNull
    private Long id;
    @NotNull(message = "(name)"+"{validation.required}")
    @Length(min = 2 , message ="{validation.name.length}")
    private String name;
    @Length(min = 2 , message ="{validation.name.length}")
    @NotNull(message = ("Name Ar")+"{validation.required}")
    @Column(name = "name_ar")
    private String nameAr;
}
