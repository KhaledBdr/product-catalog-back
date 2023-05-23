package com.fawry.productcatalog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @SequenceGenerator(name = "orderItem_id_seq", sequenceName = "orderItem_id_seq" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderItem_id_seq")
    @Id
    private Long id;
    private int quantity;
    private double price;
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private double discountPercentage = 0;

    public OrderItem(int quantity, double price, Product product, double discountPercentage) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.discountPercentage = discountPercentage;
    }
}