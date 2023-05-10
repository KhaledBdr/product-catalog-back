package com.fawry.productcatalog.service;

import com.fawry.productcatalog.dto.ProductDTO;
import com.fawry.productcatalog.dto.UpdateProductNameDTO;
import com.fawry.productcatalog.dto.UpdateProductPriceDTO;
import com.fawry.productcatalog.dto.UpdateProductQuantityDTO;

import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO getById(Long id);
    List<ProductDTO> getAll();
    ProductDTO editProductQuantity(UpdateProductQuantityDTO productDTO);
    ProductDTO editProductPrice(UpdateProductPriceDTO productDTO);
    List<ProductDTO> filterByCategory(Long id);
    ProductDTO editProductName(UpdateProductNameDTO productDTO);
    void delete (Long id);
}
