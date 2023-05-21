package com.fawry.productcatalog.service;

import com.fawry.productcatalog.dto.CategoryDTO;
import com.fawry.productcatalog.dto.ProductDTO;
import com.fawry.productcatalog.entity.Category;
import com.fawry.productcatalog.mapper.CategoryMapper;
import com.fawry.productcatalog.repository.CategoryRepository;
import com.fawry.productcatalog.service.implemenation.CategoryServiceImpl;
import com.fawry.productcatalog.service.implemenation.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class CategoryServiceTest {
    @InjectMocks
    private CategoryServiceImpl categoryService;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private ProductServiceImpl productService;
    @Mock
    private CategoryMapper categoryMapper;
    Long id = 1L;
    String name = "cat";
    CategoryDTO categoryDTO = new CategoryDTO(id, name , "");
    Category category = new Category(id, name , "");
    @BeforeEach
    void initializer(TestInfo info) {
        if (info.getDisplayName().equals("editCategoryNameTest")){
            return;
        }
        Mockito.when(categoryMapper.map(any()))
                .thenReturn(categoryDTO);
        Mockito.when(categoryMapper.unmap(any()))
                .thenReturn(category);

        Mockito.when(categoryRepository.findById(id))
                .thenReturn(Optional.of(category));
    }
    @Test
    void addCategoryTest() {
        Mockito.when(categoryRepository.save(category))
                .thenReturn(category);
        assertEquals(categoryDTO, categoryService.addCategory(categoryDTO));
    }

    @Test
    void getByIdTest() {
        assertEquals(categoryDTO , categoryService.addCategory(categoryDTO));
    }

    @Test
    void getAllTest() {
        Mockito.when(categoryRepository.findAll())
                .thenReturn(List.of(category));
        assertEquals(List.of(categoryDTO) , categoryService.findAll());
    }

    @Test
    void editCategoryNameTest() {
        CategoryDTO updatedDTO = new CategoryDTO(1L , "cat2" , "");
        Category updated = new Category(1L , "cat2" , "");
        Mockito.when(categoryRepository.updateNameById(updatedDTO.getName() , updatedDTO.getId()))
                .thenReturn(1);
        Mockito.when(categoryMapper.map(updated))
                        .thenReturn(updatedDTO);
        Mockito.when(categoryRepository.findById(id))
                        .thenReturn(Optional.of(updated));
        assertEquals(updatedDTO , categoryService.editCategoryName(updatedDTO));
    }
}
