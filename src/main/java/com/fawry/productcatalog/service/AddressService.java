package com.fawry.productcatalog.service;

import com.fawry.productcatalog.dto.AddressDTO;
import com.fawry.productcatalog.entity.Address;

import java.util.List;

public interface AddressService {
    AddressDTO addAddress(AddressDTO address);

    AddressDTO findAddress(Long id);

    List<AddressDTO> findAllUserAddress(Long userId);

    void deleteAddress(long id);
}
