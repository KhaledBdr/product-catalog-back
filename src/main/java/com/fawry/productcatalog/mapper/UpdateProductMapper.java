package com.fawry.productcatalog.mapper;

import com.fawry.productcatalog.dto.ProductDTO;
import com.fawry.productcatalog.dto.UpdateProductNameDTO;
import com.fawry.productcatalog.entity.Product;
import org.mapstruct.Mapper;

@Mapper
public interface UpdateProductMapper {
    UpdateProductNameDTO ProductToUpdateProduct(ProductDTO product);
    ProductDTO UpdateNameToProduct(UpdateProductNameDTO product);
}
