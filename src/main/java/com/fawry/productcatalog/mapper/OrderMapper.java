package com.fawry.productcatalog.mapper;

import com.fawry.productcatalog.dto.AddressDTO;
import com.fawry.productcatalog.dto.OrderDTO;
import com.fawry.productcatalog.entity.Address;
import com.fawry.productcatalog.entity.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {
    OrderDTO toDTO(Order order);
    Order toEntity(OrderDTO orderDTO);

}
