package com.fawry.productcatalog.service;

import com.fawry.productcatalog.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO addCategory(CategoryDTO category);
    CategoryDTO findById(Long id);
    CategoryDTO editCategoryName(CategoryDTO category);
    void deleteById (Long id);
    void activate(Long id);

    List<CategoryDTO> findAll(Boolean isAdmin);
}
