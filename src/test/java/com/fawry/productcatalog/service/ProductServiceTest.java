package com.fawry.productcatalog.service;

import com.fawry.productcatalog.dto.*;
import com.fawry.productcatalog.entity.Category;
import com.fawry.productcatalog.entity.Product;
import com.fawry.productcatalog.mapper.CategoryMapper;
import com.fawry.productcatalog.mapper.ProductMapper;
import com.fawry.productcatalog.repository.ProductRepository;
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
class ProductServiceTest {
    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductMapper productMapper;
    @Mock
    private CategoryMapper categoryMapper;
    Long id = 1L;
    String name = "test";
    String nameAr = "اختبار";
    double price = 11.0;
    int quantity = 20;
    Category category = new Category(1L, "catTest" ,"");
    CategoryDTO emptyCategoryDTO = new CategoryDTO(1L , "" , "");
    Category emptyCategory = new Category(1L , "" , "");
    private ProductDTO productDTO = new ProductDTO(id,name , nameAr,"",price,quantity,category);
    private Product product = new Product(id,name , nameAr,"",price,quantity,category);


    @BeforeEach
    void initializer(TestInfo info){
        if (info.getDisplayName().equals("editNameTest") ||
                info.getDisplayName().equals("editPriceTest") ||
                info.getDisplayName().equals("editQuantityTest")
        ){
            return;
        }else{
            Mockito.when(productMapper.map(product))
                    .thenReturn(productDTO);
            Mockito.when(productMapper.unmap(productDTO))
                    .thenReturn(product);
            Mockito.when(categoryMapper.map(category))
                    .thenReturn(emptyCategoryDTO);
            Mockito.when(categoryMapper.unmap(emptyCategoryDTO))
                    .thenReturn(emptyCategory);
            Mockito.when(
                    productRepository.findByCategoryOrPriceBetween(emptyCategory , 100.0 ,100.0)
                    )
                    .thenReturn(List.of(product));
        }
    }

    @Test
    void getByIdTest(){
        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        assertEquals(productDTO ,productService.findById(1L));
    }
    @Test
    void getAllTest(){
        Mockito.when(productRepository.findAll())
                .thenReturn(List.of(product));

        assertEquals(List.of(productDTO) , productService.findAll() );
    }
    @Test
    void AddElementTest(){
        Mockito.when(productRepository.save(product))
                .thenReturn(product);
        assertEquals(productDTO , productService.addProduct(productDTO));
    }
    @Test
    void editNameTest() {
        String newName = "test2";
        String newNameAr = "الاختيار 2";

        UpdateProductNameDTO serviceParam = new UpdateProductNameDTO(id , newName , newNameAr);
        Product excepectedProduct = new Product(
          id,newName, newNameAr, "", price, quantity, category);

        Mockito.when(
                productRepository.updateNameAndNameArById(
                        any(String.class) , any(String.class),any(Long.class))
        ).thenReturn(1);

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(excepectedProduct));

        productDTO.setName(excepectedProduct.getName());
        productDTO.setNameAr(excepectedProduct.getNameAr());

        Mockito.when(productMapper.map(excepectedProduct))
                .thenReturn(productDTO);
        assertEquals(productDTO , productService.editProductName(serviceParam));
    }

    @Test
    void editPriceTest() {
        UpdateProductPriceDTO serviceParam = new UpdateProductPriceDTO(1L , 10);

        Mockito.when(productRepository.updatePriceById(10 , 1L))
                .thenReturn(1);
        product.setPrice(serviceParam.getPrice());
        Mockito.when(productRepository.findById(1L))
                        .thenReturn(Optional.of(product));
        productDTO.setPrice(serviceParam.getPrice());
        Mockito.when(productMapper.map(any()))
                        .thenReturn(productDTO);
        assertEquals(productDTO,productService.editProductPrice(serviceParam));
    }

    @Test
    void editQuantityTest() {
        UpdateProductQuantityDTO serviceParam = new UpdateProductQuantityDTO(1L , 10);

        Mockito.when(productRepository.updateProductQuantity(10 , 1L))
                .thenReturn(1);
        product.setPrice(serviceParam.getQuantity());
        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));
        productDTO.setQuantity(serviceParam.getQuantity());
        Mockito.when(productMapper.map(any()))
                .thenReturn(productDTO);
        assertEquals(productDTO,productService.editProductQuantity(serviceParam));
    }
//    @Test
    void filterByPriceOrCategoryTest(){
        List<ProductDTO> productDTOS = productService
                .filterByPriceOrCategory(emptyCategoryDTO, 100.0, 150.0);
        assertEquals(List.of(productDTO) , productDTOS);
    }
}
