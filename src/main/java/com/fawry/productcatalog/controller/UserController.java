package com.fawry.productcatalog.controller;

import com.fawry.productcatalog.dto.PresentOrderDTO;
import com.fawry.productcatalog.dto.UserDTO;
import com.fawry.productcatalog.entity.User;
import com.fawry.productcatalog.service.UserService;
import com.fawry.productcatalog.service.implemenation.OrderServiceImpl;
import com.fawry.productcatalog.service.implemenation.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private UserServiceImpl userService;
    @PostMapping
    public UserDTO addUser(@Valid @RequestBody UserDTO user) {
        return userService.addUser(user);
    }
    @GetMapping("/{id}/orders")
    public List<PresentOrderDTO> getAllUserOrders(@PathVariable Long id){
        return orderService.findAllUserOrders(id);
    }
}