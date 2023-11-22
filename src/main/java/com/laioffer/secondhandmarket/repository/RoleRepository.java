package com.laioffer.secondhandmarket.repository;

import java.util.Optional;

import com.laioffer.secondhandmarket.entity.Role;
import com.laioffer.secondhandmarket.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByName(UserRole name);
}