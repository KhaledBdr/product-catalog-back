package com.fawry.productcatalog.service.implemenation;

import com.fawry.productcatalog.dto.AddressDTO;
import com.fawry.productcatalog.entity.Address;
import com.fawry.productcatalog.entity.User;
import com.fawry.productcatalog.exception.EntityNotFoundException;
import com.fawry.productcatalog.mapper.AddressMapper;
import com.fawry.productcatalog.repository.AddressRepository;
import com.fawry.productcatalog.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public AddressDTO addAddress(AddressDTO address) {
        return addressMapper
                .toDTO(addressRepository
                        .save(addressMapper
                                .toEntity(address)
                        )
                );
    }

    @Override
    public AddressDTO findAddress(Long id) {
        return addressMapper.toDTO(addressRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new)
        );
    }

    @Override
    public List<AddressDTO> findAllUserAddress(Long userId) {
        User user = new User();
        user.setId(userId);
        return addressRepository
                .findByUser(user)
                .stream()
                .map(addressMapper::toDTO)
                .toList();
    }


    @Override
    public void deleteAddress(long id) {
        addressRepository.deleteById(id);
    }
}
