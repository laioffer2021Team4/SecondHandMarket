package com.laioffer.SecondHandMarket.repository;

import java.util.Optional;

import com.laioffer.SecondHandMarket.entity.Role;
import com.laioffer.SecondHandMarket.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRole name);
}