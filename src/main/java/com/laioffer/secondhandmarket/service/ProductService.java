package com.laioffer.secondhandmarket.service;

import com.laioffer.secondhandmarket.entity.Address;
import com.laioffer.secondhandmarket.entity.AddressType;
import com.laioffer.secondhandmarket.entity.Customer;
import com.laioffer.secondhandmarket.entity.Product;
import com.laioffer.secondhandmarket.entity.ProductImage;
import com.laioffer.secondhandmarket.entity.SaleList;
import com.laioffer.secondhandmarket.payload.request.AddProductRequest;
import com.laioffer.secondhandmarket.repository.CustomerRepository;
import com.laioffer.secondhandmarket.repository.ProductRepository;
import com.laioffer.secondhandmarket.repository.SaleListRepository;
import com.laioffer.secondhandmarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Component
public class ProductService {

    // private final ProductDao productDao;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    SaleListRepository saleListRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int productId) {
        return productRepository.findProductById(productId)
                .orElseThrow(() -> new RuntimeException("Product with id: " + productId + " does not exist"));
    }

    public void deleteProduct(int productId) {
        productRepository.deleteProductById(productId);
    }

    public void addProduct(AddProductRequest addProductRequest) {
        Customer customer = customerService.getCustomer(addProductRequest.getEmail());

        SaleList saleList = customer.getSaleList();

        if (saleList == null) {
            customer.setSaleList(SaleList.builder().build());
            customer = customerRepository.save(customer);
            saleList = customer.getSaleList();
        }

        if (saleList.getProductList() == null) {
            saleList.setProductList(new HashSet<>());
        }

        Set<ProductImage> images = new HashSet<>();

        addProductRequest.getUuids().forEach(e ->
                images.add(new ProductImage().toBuilder().uuid(e).build()));

        saleList.getProductList().add( Product.builder()
                .address(Address.builder()
                        .type(AddressType.Selling)
                        .zipcode(addProductRequest.getZipcode())
                        .street(addProductRequest.getStreet())
                        .city(addProductRequest.getCity())
                        .states(addProductRequest.getState())
                        .build())
                .customer(customer)
                .condition(addProductRequest.getCondition())
                .description(addProductRequest.getDescription())
                .postDate(new Date(System.currentTimeMillis()))
                .title(addProductRequest.getTitle())
                .price(addProductRequest.getPrice())
                .isSold(false)
                .image(images).build());

        saleListRepository.save(saleList);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProductByKeyword(String keyword) {
        List<Product> listC = productRepository.findByCategoryContaining(keyword);
        List<Product> listD = productRepository.findByDescriptionContaining(keyword);
        List<Product> listM = productRepository.findByManufacturerContaining(keyword);
        List<Product> listN = productRepository.findByTitleContaining(keyword);
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
