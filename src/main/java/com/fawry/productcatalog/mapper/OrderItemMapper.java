package com.fawry.productcatalog.mapper;

import com.fawry.productcatalog.dto.OrderItemDTO;
import com.fawry.productcatalog.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderItemMapper {
    @Mapping(target = "productName" , source = "product.name")
    OrderItemDTO toDTO(OrderItem orderItem);
    OrderItem toEntity(OrderItemDTO orderItem);
}
