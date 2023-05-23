package com.fawry.productcatalog.mapper;

import com.fawry.productcatalog.dto.UserDTO;
import com.fawry.productcatalog.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);

}
