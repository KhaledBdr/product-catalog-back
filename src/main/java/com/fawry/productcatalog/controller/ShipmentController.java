package com.fawry.productcatalog.controller;

import com.fawry.productcatalog.dto.ShipmentDTO;
import com.fawry.productcatalog.service.implemenation.ShipmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/orders/shipments")
public class ShipmentController {
    @Autowired
    private ShipmentServiceImpl shipmentService;
    @PutMapping("/{id}/updateState")
    public ShipmentDTO updateState(@PathVariable Long id,@RequestBody ShipmentDTO shipmentDTO){
        return shipmentService.updateShipmentState(id , shipmentDTO);
    }
    @PutMapping("/{id}/ensureDelivery")
    public ShipmentDTO ensureUserDelivery(@PathVariable Long id){
        return shipmentService.changeUserAcknowledge(id);
    }
    @PostMapping
    public ShipmentDTO addShipment(@Valid @RequestBody ShipmentDTO shipmentDTO){
        return shipmentService.addShipment(shipmentDTO);
    }
    @GetMapping("/{id}")
    public ShipmentDTO getShipment(@PathVariable Long id){
        return shipmentService.getShipment(id);
    }
}
