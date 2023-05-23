package com.fawry.productcatalog.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name = "order_id_seq", sequenceName = "order_id_seq" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_id_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Boolean shipment = false;
    private double discountPercentage = 0;
    private LocalDate date = LocalDate.now();

    @OneToMany(cascade = {CascadeType.ALL})

    private List<OrderItem> orderItems;
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    public Order(User user,  double discountPercentage , List<OrderItem> orderItems) {
        this.user = user;
        this.discountPercentage = discountPercentage;
        this.orderItems = orderItems;
    }
}
