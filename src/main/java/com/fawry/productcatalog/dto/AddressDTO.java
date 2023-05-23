package com.fawry.productcatalog.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fawry.productcatalog.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDTO {
        private Long id;
        @JsonIgnore
        @NotNull
        private User user;
        @NotNull
        @NotBlank
        @NotEmpty
        private String government;
        @NotNull
        @NotBlank
        @NotEmpty
        private String town;
        private String village;
        @NotNull
        @NotBlank
        @NotEmpty
        private String street;
        @NotNull
        private int buildingNumber ;

    public AddressDTO(User user, String government, String town, String village, String street, int buildingNumber) {
        this.user = user;
        this.government = government;
        this.town = town;
        this.village = village;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }
}
