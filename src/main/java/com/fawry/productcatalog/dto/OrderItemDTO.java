package com.fawry.productcatalog.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long id;
    private int quantity;
    private double price;
    private String productName;
    private double discountPercentage = 0;
}
