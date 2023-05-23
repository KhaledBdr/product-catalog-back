package com.fawry.productcatalog.mapper;

import com.fawry.productcatalog.dto.ShipmentDTO;
import com.fawry.productcatalog.entity.Shipment;
import org.mapstruct.Mapper;

@Mapper
public interface ShipmentMapper {
    ShipmentDTO toDTO(Shipment shipment);
    Shipment toEntity(ShipmentDTO shipmentDTO);
}
