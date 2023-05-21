package com.fawry.productcatalog.mapper;

import com.fawry.productcatalog.dto.ProductDTO;
import com.fawry.productcatalog.dto.UpdateProductNameDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UpdateProductMapper {
    UpdateProductNameDTO productToUpdateProduct(ProductDTO product);
    ProductDTO updateNameToProduct(UpdateProductNameDTO product);
}
