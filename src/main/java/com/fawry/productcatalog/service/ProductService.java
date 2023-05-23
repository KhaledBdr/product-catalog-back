package com.fawry.productcatalog.service;

import com.fawry.productcatalog.dto.*;

import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO findById(Long id);

    List<ProductDTO> findAll(Boolean isAdmin);
    ProductDTO editProductQuantity(UpdateProductQuantityDTO productDTO);
    ProductDTO editProductPrice(UpdateProductPriceDTO productDTO);
    ProductDTO editProductName(UpdateProductNameDTO productDTO);
    List<ProductDTO>filterByPriceOrCategory(CategoryDTO category,Double minPrice , Double maxPrice );
    void delete (Long id);
    void activate(Long id);
}
