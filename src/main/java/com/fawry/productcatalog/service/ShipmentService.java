package com.fawry.productcatalog.service;

import com.fawry.productcatalog.dto.ShipmentDTO;
import com.fawry.productcatalog.entity.ShipmentState;

public interface ShipmentService {
    ShipmentDTO addShipment(ShipmentDTO shipmentDTO);

    ShipmentDTO updateShipmentState(Long id, ShipmentDTO shipmentDTO);

    ShipmentDTO changeUserAcknowledge(Long id);

    ShipmentDTO getShipment(Long id);
}
