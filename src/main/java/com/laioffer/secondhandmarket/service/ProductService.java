package com.laioffer.secondhandmarket.service;

import com.laioffer.secondhandmarket.entity.Product;
import com.laioffer.secondhandmarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<Product> listC = repository.findByCategoryContaining(keyword);
        List<Product> listD = repository.findByDescriptionContaining(keyword);
        List<Product> listM = repository.findByManufacturerContaining(keyword);
        List<Product> listN = repository.findByNameContaining(keyword);
        // Deduplication
        List<Product> finalList = new ArrayList<>();
        Set<Integer> idSet = new HashSet<>();
        updateFinalList(listC, finalList, idSet);
        updateFinalList(listD, finalList, idSet);
        updateFinalList(listM, finalList, idSet);
        updateFinalList(listN, finalList, idSet);
        return finalList;
    }

    private void updateFinalList(List<Product> rawList, List<Product> finalList, Set<Integer> idSet) {
        if (rawList==null || rawList.size()==0) {
            return;
        }
        for (Product product : rawList) {
            if (!idSet.contains(product.getId())) {
                idSet.add(product.getId());
                finalList.add(product);
            }
        }
    }
}
