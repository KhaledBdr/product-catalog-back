package com.fawry.productcatalog.repository;

import com.fawry.productcatalog.entity.Category;
import com.fawry.productcatalog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Transactional
    @Modifying
    @Query(value = "update Product set deleted = ?1 where id = ?2")
    int changeDeletedState(Boolean deleted , Long id);
    @Override
    @Query (value = " Select p from Product p")
    List<Product> findAll();
    @Query (value = "Select p from Product p where p.deleted = false")
    List<Product> findAllActive();
    @Query(value = "select p from Product p where p.deleted = false AND (category" +
            " = coalesce(?1,p.category) or price between" +
            " coalesce(?2,p.price) and coalesce(?3,sum(p.price+20))) ")
    List<Product> findByCategoryOrPriceBetween(Category category , double priceStart, double priceEnd);

    @Transactional
    @Modifying
    @Query("update Product p set p.name = ?1, p.nameAr = ?2 where p.id = ?3")
    int updateNameAndNameArById(String name, String nameAr, Long id);

    @Transactional
    @Modifying
    @Query("update Product p set p.price = ?1 where p.id = ?2")
    int updatePriceById(double price, Long id);
    @Transactional
    @Modifying
    @Query("update Product set quantity = ?1 where id = ?2")
    int updateProductQuantity(int quantity , Long id);
}
