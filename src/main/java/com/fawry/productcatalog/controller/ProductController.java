package com.fawry.productcatalog.controller;

import com.fawry.productcatalog.dto.*;
import com.fawry.productcatalog.service.implemenation.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Validated
public class ProductController {
    @Autowired private ProductServiceImpl productService;
    @GetMapping("/all")
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }
    @GetMapping("/filter/categoryAndPrice")
    public List<ProductDTO> filterByCatAndPriceWay2(
            @RequestBody FilterDTO input) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(input.getId());
        return productService
                .filterByPriceAndCategory(
                        categoryDTO ,
                        input.getMin(),
                        input.getMax()
                );
    }
    @GetMapping("/filter/categoryOrPrice")
    public List<ProductDTO> filterByCatOrPrice(
            @RequestBody FilterDTO input
    ) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(input.getId());
        return productService.filterByPriceOrCategory(categoryDTO , input.getMin() , input.getMax());
    }
    @GetMapping("/id/{id}")
    public ProductDTO getById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }
    @PostMapping
    public ProductDTO add(@RequestBody @Valid ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }
    @PutMapping("/updatePrice")
    public ProductDTO updatePrice(@RequestBody @Valid UpdateProductPriceDTO product) {
        return productService.editProductPrice(product);
    }
    @PutMapping("/updateName")
    public ProductDTO updateName(@RequestBody @Valid UpdateProductNameDTO product) {
        return productService.editProductName(product);
    }
    @PutMapping("/updateQuantity")
    public ProductDTO updateQuantity(@RequestBody @Valid UpdateProductQuantityDTO product) {
        return productService.editProductQuantity(product);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
    @PutMapping("/activate/{id}")
    public void activate(@PathVariable Long id) {
        productService.activate(id);
    }
}
