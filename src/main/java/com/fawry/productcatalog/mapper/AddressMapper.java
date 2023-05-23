package com.fawry.productcatalog.mapper;

import com.fawry.productcatalog.dto.AddressDTO;
import com.fawry.productcatalog.entity.Address;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {
    AddressDTO toDTO(Address address);
    Address toEntity(AddressDTO address);

}
