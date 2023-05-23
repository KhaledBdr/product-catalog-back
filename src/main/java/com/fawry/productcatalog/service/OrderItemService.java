package com.fawry.productcatalog.service;

import com.fawry.productcatalog.dto.ProductDTO;
import com.fawry.productcatalog.entity.Order;
import com.fawry.productcatalog.entity.OrderItem;
import com.fawry.productcatalog.entity.Product;

import java.util.List;

public interface OrderItemService {
    OrderItem addItem(OrderItem item);
    List<OrderItem> addAllItem(List<OrderItem> item);
    OrderItem updateItem (OrderItem item);
    OrderItem findItem(Long id);
    List<OrderItem> findProductOrders (ProductDTO product);
    void deleteItem (Long id);
}
