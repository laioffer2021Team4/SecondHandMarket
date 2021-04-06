package com.laioffer.secondhandmarket.repository;

import com.laioffer.secondhandmarket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    Product findProductById(int id);

    void deleteProductById(int id);

    Product save(Product product);

    List<Product> findByCategoryContaining(String keyword);

    List<Product> findByDescriptionContaining(String keyword);

    List<Product> findByManufacturerContaining(String keyword);

    List<Product> findByNameContaining(String keyword);
}
