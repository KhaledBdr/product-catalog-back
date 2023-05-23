package com.fawry.productcatalog.controller;

import com.fawry.productcatalog.dto.OrderDTO;
import com.fawry.productcatalog.dto.PresentOrderDTO;
import com.fawry.productcatalog.service.implemenation.OrderServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @GetMapping
    public List<PresentOrderDTO> getAllOrders(@RequestParam("isAdmin") boolean isAdmin){
        return orderService.findAll();
    }
    @GetMapping("/{id}")
    public PresentOrderDTO getOrder(@PathVariable Long id){
        return orderService.findOrder(id);
    }
    @PostMapping
    public PresentOrderDTO addOrder(@RequestBody @Valid OrderDTO orderDTO){
        return orderService.addOrder(orderDTO);
    }
    @GetMapping("/duration")
    public List<PresentOrderDTO> filterOrders(@RequestParam("start") String start,@RequestParam("end") String end){
        return orderService.findAllOrdersBetween(start , end);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}