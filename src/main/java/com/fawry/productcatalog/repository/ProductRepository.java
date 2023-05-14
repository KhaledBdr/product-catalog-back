package com.fawry.productcatalog.repository;

import com.fawry.productcatalog.entity.Category;
import com.fawry.productcatalog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Transactional
    @Modifying
    @Query(value = "update product  set deleted = ?1 where id = ?2", nativeQuery=true)

    int updateDeletedById(Boolean deleted, Long id);
    @Query(value = "select p from Product p where category = ?1 or price between ?2 and ?3")
    List<Product> findByCategoryOrPriceBetween(Category category , double priceStart, double priceEnd);

    List<Product> findByPriceBetweenAndCategory(double priceStart, double priceEnd, Category category);
    List<Product> findByCategory(Category category);
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
