package com.fawry.productcatalog.service.implemenation;

import com.fawry.productcatalog.dto.ProductDTO;
import com.fawry.productcatalog.entity.Order;
import com.fawry.productcatalog.entity.OrderItem;
import com.fawry.productcatalog.exception.EntityNotFoundException;
import com.fawry.productcatalog.mapper.ProductMapper;
import com.fawry.productcatalog.repository.OrderItemRepository;
import com.fawry.productcatalog.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository itemRepository;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public OrderItem addItem(OrderItem item) {
        return itemRepository.save(item);
    }

    @Override
    public List<OrderItem> addAllItem(List<OrderItem> items) {
        return itemRepository.saveAll(items).stream().toList();
    }

    @Override
    public OrderItem updateItem(OrderItem item) {
        findItem(item.getId());
        return itemRepository.save(item);
    }

    @Override
    public OrderItem findItem(Long id) {
        return itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<OrderItem> findProductOrders(ProductDTO product) {
        return itemRepository.findByProduct(productMapper.unmap(product));
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
