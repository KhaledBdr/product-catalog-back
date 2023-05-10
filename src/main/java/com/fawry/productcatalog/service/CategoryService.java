package com.fawry.productcatalog.service;

import com.fawry.productcatalog.dto.CategoryDTO;
import com.fawry.productcatalog.dto.ProductDTO;
import com.fawry.productcatalog.entity.Category;

import java.util.List;

public interface CategoryService {

    CategoryDTO addCategory(CategoryDTO category);
    CategoryDTO getById(Long id);
    List<CategoryDTO> getAll();
    CategoryDTO editCategoryName(CategoryDTO category);
    List<ProductDTO> getCategoryProducts(Long id);
    void delete (Long id);
}
