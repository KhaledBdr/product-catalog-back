package com.fawry.productcatalog.repository;

import com.fawry.productcatalog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Long> {
    @Transactional
    @Modifying
    @Query(value = "update Category set deleted = ?1 where id = ?2")
    int updateDeletedById(Boolean deleted, Long id);
    @Transactional
    @Modifying
    @Query("update Category set name = ?1 where id = ?2")
    int updateNameById(String name, Long id);


    @Override
    @Query(value = "Select c from Category c")
    List<Category> findAll();
    @Query(value = "Select c from Category c where deleted = false")
    List<Category> findAllActive();
}
