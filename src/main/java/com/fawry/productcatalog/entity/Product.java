package com.fawry.productcatalog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq" , allocationSize = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_id_seq")
    @Id
    private Long id;
    @Length(min = 2 , message ="{validation.name.length}")
    private String name;

    @Length(min = 2 , message ="{validation.name.length}")
    private String nameAr;
    private String description;
    @NotNull
    @Min(value = 1 , message ="{validation.price}")
    private double price;
    @NotNull

    @Min(value = 0 , message ="{validation.quantity}")
    private int quantity;
    @ManyToOne
    private Category category;

    public Product(String name, String nameAr, String description, double price, int quantity, Category category) {
        this.name = name;
        this.nameAr = nameAr;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
}
