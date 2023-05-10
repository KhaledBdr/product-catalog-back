package com.fawry.productcatalog.mapper;

import com.fawry.productcatalog.dto.ProductDTO;
import com.fawry.productcatalog.entity.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDTO map(Product product);
    Product unmap(ProductDTO product);
}
