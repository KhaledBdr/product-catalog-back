package com.fawry.productcatalog.service;

import com.fawry.productcatalog.dto.CategoryDTO;
import com.fawry.productcatalog.dto.ProductDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO addCategory(CategoryDTO category);
    CategoryDTO findById(Long id);
    List<CategoryDTO> findAll();
    CategoryDTO editCategoryName(CategoryDTO category);
    List<ProductDTO> findCategoryProducts(Long id);
    void deleteById (Long id);
    void activate(Long id);
}
