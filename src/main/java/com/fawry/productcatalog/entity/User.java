package com.fawry.productcatalog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "users_id_seq")
    @Id
    private Long id;
    @NotNull
    @NotBlank
    @Length(min = 10)
    private String name;
    @NotNull
    private String phone;
    @Email
    private String email;
    private LocalDate birthDate = null;
    private LocalDate joinDate = LocalDate.now();
    @NotNull
    @Length(min = 8)
    @JsonIgnore
    private String password;
    public User(String name, String phone, String email, LocalDate birthDate,  String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
    }
}
