package com.fawry.productcatalog.service;

import com.fawry.productcatalog.dto.OrderDTO;
import com.fawry.productcatalog.dto.PresentOrderDTO;

import java.util.List;

public interface OrderService {
    PresentOrderDTO addOrder(OrderDTO order);
    PresentOrderDTO findOrder(Long id);



    List<PresentOrderDTO> findAllUserOrders(Long id);

    List<PresentOrderDTO> findAllOrdersBetween(String start, String end);

    void deleteOrder(Long id);

    List<PresentOrderDTO> findAll();
}
