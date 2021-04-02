package com.laioffer.secondhandmarket.service;

import com.laioffer.secondhandmarket.dao.ProductDao;
import com.laioffer.secondhandmarket.entity.Product;
import com.laioffer.secondhandmarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class ProductService extends AbstractService {

    // private final ProductDao productDao;
    private final ProductRepository repository;

    @Autowired
    protected ProductService(EntityManagerFactory factory, ProductRepository repository) {
        super(factory);
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(int productId) {
        return repository.findProductById(productId);
    }

    public void deleteProduct(int productId) {
        repository.deleteProductById(productId);
    }

    public void addProduct(Product product) {
        repository.save(product);
    }

    public void updateProduct(Product product) {
        repository.save(product);
    }

    public List<Product> getProductByKeyword(String keyword) {
        return repository.findByDescriptionContaining(keyword);
    }
}
