package com.fawry.productcatalog.mapper;

import com.fawry.productcatalog.dto.CategoryDTO;
import com.fawry.productcatalog.entity.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryDTO map(Category category);
    Category unmap(CategoryDTO categoryDTO);
}
