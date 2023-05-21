package com.fawry.productcatalog.controller;

import com.fawry.productcatalog.dto.CategoryDTO;
import com.fawry.productcatalog.service.implemenation.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;
    @GetMapping("/all")
    public List<CategoryDTO> getAllActiveCategories() {
        return categoryService.findAllActive();
    }
    @GetMapping("/all/admin")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.findAll();
    }
    @GetMapping("/id/{id}")
    public CategoryDTO getById(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }
    @PostMapping
    public CategoryDTO addCategory(@RequestBody @Valid CategoryDTO category){
        return categoryService.addCategory(category);
    }
    @PutMapping("/updateName")
    public CategoryDTO editCategoryName(@RequestBody @Valid CategoryDTO category) {
        return categoryService.editCategoryName(category);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
    }
    @PutMapping("/activate/{id}")
    public void activate(@PathVariable Long id) {
        categoryService.activate(id);
    }
}
