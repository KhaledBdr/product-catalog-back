package com.fawry.productcatalog.repository;

import com.fawry.productcatalog.entity.Order;
import com.fawry.productcatalog.entity.OrderItem;
import com.fawry.productcatalog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByProduct(Product product);
}
