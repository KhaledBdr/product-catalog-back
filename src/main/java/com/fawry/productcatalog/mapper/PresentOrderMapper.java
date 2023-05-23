package com.fawry.productcatalog.mapper;

import com.fawry.productcatalog.dto.PresentOrderDTO;
import com.fawry.productcatalog.entity.Order;
import com.fawry.productcatalog.entity.OrderItem;
import com.fawry.productcatalog.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(uses = OrderItemMapper.class)
public interface PresentOrderMapper {
    @Mappings({
            @Mapping(source = "user.id" , target = "userId")
    })
    PresentOrderDTO toDTO (Order order);
}
