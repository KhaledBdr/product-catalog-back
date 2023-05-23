package com.fawry.productcatalog.repository;

import com.fawry.productcatalog.entity.Order;
import com.fawry.productcatalog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Transactional
    @Modifying
    @Query("update Order o set o.shipment = ?1 where o.id = ?2")
    int updateShipmentById(Boolean shipment, Long id);
    List<Order> findByDateBetween(LocalDate dateStart, LocalDate dateEnd);
    List<Order> findByUser(User user);
}
