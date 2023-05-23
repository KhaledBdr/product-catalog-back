package com.fawry.productcatalog.service.implemenation;

import com.fawry.productcatalog.dto.UserDTO;
import com.fawry.productcatalog.entity.User;
import com.fawry.productcatalog.exception.EntityNotFoundException;
import com.fawry.productcatalog.mapper.UserMapper;
import com.fawry.productcatalog.repository.UserRepository;
import com.fawry.productcatalog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    @Override
    public UserDTO addUser(UserDTO user) {
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(user)));
    }

}