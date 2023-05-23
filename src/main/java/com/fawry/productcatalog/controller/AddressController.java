package com.fawry.productcatalog.controller;

import com.fawry.productcatalog.dto.AddressDTO;
import com.fawry.productcatalog.service.implemenation.AddressServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping
public class AddressController {
    @Autowired
    private AddressServiceImpl addressService;

    @PostMapping("/addresses")
    public AddressDTO addAddress(@Valid @RequestBody AddressDTO address) {
        return addressService.addAddress(address);
    }

    @GetMapping("/addresses/{id}")
    public AddressDTO getAddress(@PathVariable Long id) {
        return addressService.findAddress(id);
    }

    @GetMapping("/users/{id}/addresses")
    public List<AddressDTO> getUserAddresses(@PathVariable Long id) {
        return addressService.findAllUserAddress(id);
    }
    @DeleteMapping("/addresses/{id}")
    public void deleteById(@PathVariable Long id){
        addressService.deleteAddress(id);
    }
}
