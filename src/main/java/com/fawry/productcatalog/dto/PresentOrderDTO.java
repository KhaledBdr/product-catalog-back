package com.fawry.productcatalog.dto;

import com.fawry.productcatalog.entity.OrderItem;
import com.fawry.productcatalog.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class PresentOrderDTO {
    private Long id;
    @NotNull
    private Long userId;
    private Boolean shipment;
    private double discountPercentage = 0;
    private LocalDate date = LocalDate.now();
    private List<OrderItemDTO> orderItems;
}
