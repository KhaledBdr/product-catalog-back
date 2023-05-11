package com.fawry.productcatalog.dto;

import com.fawry.productcatalog.entity.Category;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    @NotNull(message = "(name)"+"{validation.required}")
    @Length(min = 2 , message ="{validation.name.length}")
    private String name;
    @Length(min = 2 , message ="{validation.name.length}")
    @NotNull(message = ("Name Ar")+"{validation.required}")
    @Column(name = "name_ar")
    private String nameAr;

    private String description;

    @NotNull(message = "Price " + " {validation.required}")
    @Min(value = 1 , message ="{validation.price}")
    private double price;
    @NumberFormat
    @NotNull(message = "Quantity " + "{ validation.required}")
    @Min(value = 0 , message ="{validation.quantity}")
    private int quantity;
    @NotNull(message = "Category " + " {validation.required}")
    private Category category;
}
