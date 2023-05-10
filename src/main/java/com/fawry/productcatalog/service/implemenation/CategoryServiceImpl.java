package com.fawry.productcatalog.service.implemenation;

import com.fawry.productcatalog.dto.CategoryDTO;
import com.fawry.productcatalog.dto.ProductDTO;
import com.fawry.productcatalog.entity.Category;
import com.fawry.productcatalog.exception.EntityNotFoundException;
import com.fawry.productcatalog.mapper.CategoryMapper;
import com.fawry.productcatalog.repository.CategoryRepository;
import com.fawry.productcatalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryDTO addCategory(CategoryDTO category) {
        return categoryMapper.map(categoryRepository.save(categoryMapper.unmap(category)));
    }

    @Override
    public CategoryDTO getById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return categoryMapper.map(category);
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<CategoryDTO> categoryDTOList = categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::map)
                .collect(Collectors.toList());
        return categoryDTOList;
    }

    @Override
    public CategoryDTO editCategoryName(CategoryDTO category) {
        int affectedRows = categoryRepository.updateNameById(category.getName(), category.getId());
        if (affectedRows == 0 )
            throw new EntityNotFoundException();
        return categoryMapper.map(categoryRepository.findById(category.getId()).get());
    }

    @Override
    public List<ProductDTO> getCategoryProducts(Long id) {
        getById(id);
        return productService.filterByCategory(id);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
