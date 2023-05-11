package com.fawry.productcatalog.service;

import com.fawry.productcatalog.dto.*;

import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO getById(Long id);
    List<ProductDTO> getAll();
    List<ProductDTO>filterByPriceAndCategory(CategoryDTO category,Double minPrice , Double maxPrice );
    List<ProductDTO>filterByPriceOrCategory(CategoryDTO category,Double minPrice , Double maxPrice );
    ProductDTO editProductQuantity(UpdateProductQuantityDTO productDTO);
    ProductDTO editProductPrice(UpdateProductPriceDTO productDTO);
    List<ProductDTO> filterByCategory(Long id);
    ProductDTO editProductName(UpdateProductNameDTO productDTO);
    void delete (Long id);

    void activate(Long id);
}
