package com.fawry.productcatalog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    @SequenceGenerator(name = "address_id_seq", sequenceName = "address_id_seq" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_id_seq")
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotNull
    private String government;
    @NotNull
    private String town;
    private String village;
    @NotNull
    private String street;
    @NotNull
    private int buildingNumber ;

    public Address(User user, String government, String town, String village, String street , int buildingNumber) {
        this.user = user;
        this.government = government;
        this.town = town;
        this.village = village;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }
}
