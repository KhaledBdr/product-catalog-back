package com.fawry.productcatalog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE category SET deleted = true WHERE id=?")
public class Category {
    @Id
    @SequenceGenerator(name = "category_id_seq", sequenceName = "category_id_seq" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "category_id_seq")

    private Long id;
    @NotNull
    @Length(min = 2 , message ="{validation.name.length}")
    private String name;
    private Boolean deleted = false;
    private String description;

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
