package com.fawry.productcatalog.repository;

import com.fawry.productcatalog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface CategoryRepository extends JpaRepository<Category , Long> {
    @Transactional
    @Modifying
    @Query("update Category c set c.name = ?1 where c.id = ?2")
    int updateNameById(String name, Long id);
}
