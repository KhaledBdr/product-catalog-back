package com.fawry.productcatalog.dto;

import com.fawry.productcatalog.entity.OrderItem;
import com.fawry.productcatalog.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    @NotNull
    private User user;
    private Boolean shipment = false;
    private double discountPercentage = 0;
    private LocalDate date = LocalDate.now();
    @NotNull
    @Size(min = 1 , message = "Please add at least order item")
    private List<OrderItem> orderItems;
    public OrderDTO(User user, double discountPercentage , List<OrderItem> orderItems) {
        this.user = user;
        this.discountPercentage = discountPercentage;
        this.orderItems = orderItems;
    }
}
