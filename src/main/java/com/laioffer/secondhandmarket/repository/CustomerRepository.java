package com.laioffer.secondhandmarket.repository;

import com.laioffer.secondhandmarket.entity.Customer;
import com.laioffer.secondhandmarket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByUser(User user);
}
