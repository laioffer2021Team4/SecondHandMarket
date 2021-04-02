package com.laioffer.secondhandmarket.service;

import com.laioffer.secondhandmarket.dao.ProductDao;
import com.laioffer.secondhandmarket.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class ProductService extends AbstractService {

    private final ProductDao productDao;

    @Autowired
    protected ProductService(EntityManagerFactory factory, ProductDao productDao) {
        super(factory);
        this.productDao = productDao;
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    public void deleteProduct(int productId) {
        productDao.deleteProduct(productId);
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }
}
