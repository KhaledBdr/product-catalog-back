package com.fawry.productcatalog.service.implemenation;

import com.fawry.productcatalog.dto.CategoryDTO;
import com.fawry.productcatalog.entity.Category;
import com.fawry.productcatalog.exception.EntityNotFoundException;
import com.fawry.productcatalog.mapper.CategoryMapper;
import com.fawry.productcatalog.repository.CategoryRepository;
import com.fawry.productcatalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public CategoryDTO findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return categoryMapper.map(category);
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::map)
                .toList();
    }


    @Override
    public CategoryDTO editCategoryName(CategoryDTO category) {
        int affectedRows = categoryRepository.updateNameById(category.getName(), category.getId());
        if (affectedRows == 0 )
            throw new EntityNotFoundException();
        Optional<Category> updatedCategory = categoryRepository.findById(category.getId());
        if (updatedCategory.isPresent())
            return categoryMapper.map(updatedCategory.get());
        else throw new EntityNotFoundException();
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.updateDeletedById(true , id);
    }

    @Override
    public void activate(Long id) {
        int i = categoryRepository.updateDeletedById(false, id);
        if (i == 0 )
            throw new EntityNotFoundException();
    }

    @Override
    public List<CategoryDTO> findAllActive() {
        return categoryRepository
                .findAllActive()
                .stream()
                .map(categoryMapper::map)
                .toList();
    }
}
