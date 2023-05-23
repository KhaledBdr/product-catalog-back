package com.fawry.productcatalog.service.implemenation;

import com.fawry.productcatalog.dto.OrderDTO;
import com.fawry.productcatalog.dto.PresentOrderDTO;
import com.fawry.productcatalog.entity.Order;
import com.fawry.productcatalog.entity.User;
import com.fawry.productcatalog.exception.EntityNotFoundException;
import com.fawry.productcatalog.mapper.OrderMapper;
import com.fawry.productcatalog.mapper.PresentOrderMapper;
import com.fawry.productcatalog.repository.OrderItemRepository;
import com.fawry.productcatalog.repository.OrderRepository;
import com.fawry.productcatalog.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository itemRepository;
    @Autowired
    private ShipmentServiceImpl shipmentService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private PresentOrderMapper presentOrderMapper;
    @Override
    public PresentOrderDTO addOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return presentOrderMapper.toDTO(savedOrder);
    }

    @Override
    public PresentOrderDTO findOrder(Long id) {
        return presentOrderMapper
                .toDTO(orderRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<PresentOrderDTO> findAllUserOrders(Long id) {
        User user = new User();
        user.setId(id);
        System.out.println(user.getId());
        return orderRepository
                .findByUser(user)
                .stream()
                .map(presentOrderMapper::toDTO)
                .toList();
    }

    @Override
    public List<PresentOrderDTO> findAllOrdersBetween(String start, String end) {
        return orderRepository
                .findByDateBetween(
                        LocalDate.of(Integer.valueOf(start.substring(0,4) ),
                                Integer.valueOf(start.substring(5 ,7)) ,
                                Integer.valueOf(start.substring(8)))
                        ,
                        LocalDate.of(Integer.valueOf(end.substring(0,4) ),
                                Integer.valueOf(end.substring(5 ,7)) ,
                                Integer.valueOf(end.substring(8))))
                .stream()
                .map(presentOrderMapper::toDTO)
                .toList();
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
    @Override
    public List<PresentOrderDTO> findAll() {
        return orderRepository.findAll().stream().map(presentOrderMapper::toDTO).toList();
    }
}
