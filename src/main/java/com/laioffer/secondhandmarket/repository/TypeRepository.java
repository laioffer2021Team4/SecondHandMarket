package com.laioffer.secondhandmarket.repository;


import com.laioffer.secondhandmarket.entity.AddressType;
import com.laioffer.secondhandmarket.entity.Role;
import com.laioffer.secondhandmarket.entity.Type;
import com.laioffer.secondhandmarket.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Optional<Type> findByAddressType(AddressType addressType);
}
