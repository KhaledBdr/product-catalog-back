package com.fawry.productcatalog.service.implemenation;

import com.fawry.productcatalog.dto.ShipmentDTO;
import com.fawry.productcatalog.entity.Shipment;
import com.fawry.productcatalog.exception.EntityNotFoundException;
import com.fawry.productcatalog.mapper.ShipmentMapper;
import com.fawry.productcatalog.repository.OrderRepository;
import com.fawry.productcatalog.repository.ShipmentRepository;
import com.fawry.productcatalog.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ShipmentMapper shipmentMapper;
    @Override
    public ShipmentDTO addShipment(ShipmentDTO shipmentDTO) {
        boolean canBeShipped = orderRepository
                .findById(shipmentDTO.getOrder().getId())
                .orElseThrow(EntityNotFoundException::new)
                .getOrderItems()
                .stream().anyMatch(i -> i.getProduct().getIsShipped());
        if (canBeShipped == false){
            throw new EntityNotFoundException("Order can't be shipped");
        }
        orderRepository.updateShipmentById(true , shipmentDTO.getOrder().getId());
        return shipmentMapper.toDTO(shipmentRepository.save(shipmentMapper.toEntity(shipmentDTO)));
    }
    @Override
    public ShipmentDTO updateShipmentState(Long id, ShipmentDTO shipmentDTO) {
        Shipment savedShipment = shipmentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        savedShipment.setState(shipmentDTO.getState());
        return shipmentMapper.toDTO(shipmentRepository.save(savedShipment));
    }

    @Override
    public ShipmentDTO changeUserAcknowledge(Long id) {
        Shipment shipment = shipmentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        shipment.setUserAcknowledge(!shipment.getUserAcknowledge());
        return shipmentMapper.toDTO(shipmentRepository.save(shipment));
    }
    @Override
    public ShipmentDTO getShipment(Long id) {
        return shipmentMapper
                .toDTO(shipmentRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new));
    }
}
