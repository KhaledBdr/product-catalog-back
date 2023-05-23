package com.fawry.productcatalog.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    @Length(min = 10)
    private String name;
    @NotNull
    private String phone;
    @NotNull
    @Email
    private String email;
    private LocalDate birthDate;
    private LocalDate joinDate = LocalDate.now();

    @NotNull
    @Length(min = 8)
    @JsonIgnore
    private String password;
    public UserDTO(String name, String phone, String email, LocalDate birthDate, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
    }
}
