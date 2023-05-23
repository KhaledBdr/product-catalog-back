package com.fawry.productcatalog.repository;

import com.fawry.productcatalog.entity.Address;
import com.fawry.productcatalog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address , Long> {
    List<Address> findByUser(User user);
}
