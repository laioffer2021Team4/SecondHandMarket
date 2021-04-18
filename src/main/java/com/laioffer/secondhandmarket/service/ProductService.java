package com.laioffer.secondhandmarket.service;

import com.laioffer.secondhandmarket.entity.Address;
import com.laioffer.secondhandmarket.entity.AddressType;
import com.laioffer.secondhandmarket.entity.Customer;
import com.laioffer.secondhandmarket.entity.Product;
import com.laioffer.secondhandmarket.entity.ProductImage;
import com.laioffer.secondhandmarket.entity.SaleList;
import com.laioffer.secondhandmarket.payload.request.AddProductRequest;
import com.laioffer.secondhandmarket.payload.response.ProductResponse;
import com.laioffer.secondhandmarket.repository.CustomerRepository;
import com.laioffer.secondhandmarket.repository.ProductRepository;
import com.laioffer.secondhandmarket.repository.SaleListRepository;
import com.laioffer.secondhandmarket.repository.TypeRepository;
import com.laioffer.secondhandmarket.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Component
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    SaleListRepository saleListRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    StorageService storageService;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Transactional
    public Product getProductById(int productId) {
        Product product = productRepository.findProductById(productId)
                .orElseThrow(() -> new RuntimeException("Product with id: " + productId + " does not exist"));
        //Get images and address from database
        Set<ProductImage> images = product.getImage();
        Address address = product.getAddress();
        return product;
    }

    public void deleteProduct(int productId) {
        productRepository.deleteProductById(productId);
    }

    @Transactional
    public void addProduct(AddProductRequest addProductRequest) {
            Customer customer = customerService.getCustomerByEmail(addProductRequest.getEmail());

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

            saleList.getProductList().add(Product.builder()
                    .address(Address.builder()
                            .type(typeRepository.findByAddressType(AddressType.Selling)
                                    .orElseThrow(() -> new RuntimeException("Didn't find Address Type: " + AddressType.Selling)))
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
            storageService.deleteFiles();
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public List<ProductResponse> getProductByKeyword(String keyword) {
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
        // Convert the list of Product to list of ProductResponse
        List<ProductResponse> finalResponse = new ArrayList<>();
        for (Product product : finalList) {
            String uuid = "";
            Set<ProductImage> images = product.getImage();
            if (images.size() > 0) {
                uuid = images.iterator().next().getUuid();
            }
            finalResponse.add(ProductResponse.builder()
                                            .title(product.getTitle())
                                            .uuid(uuid)
                                            .productId(product.getId())
                                            .build());
        }
        return finalResponse;
    }

    private void updateFinalList(List<Product> rawList, List<Product> finalList, Set<Integer> idSet) {
        if (rawList == null || rawList.size() == 0) {
            return;
        }
        for (Product product : rawList) {
            if (!idSet.contains(product.getId())) {
                idSet.add(product.getId());
                finalList.add(product);
            }
        }
    }

    @Transactional
    public List<ProductResponse> listAllProductsByEmail(String email) {
        SaleList saleList = customerService.getCustomerByEmail(email).getSaleList();
        if (saleList != null && saleList.getProductList() != null) {
            List<ProductResponse> listOfProducts = new ArrayList<>();
            for  (Product product : saleList.getProductList()) {
                String uuid = "";
                Set<ProductImage> images = product.getImage();
                if (images.size() > 0) {
                    uuid = images.iterator().next().getUuid();
                }
                listOfProducts.add(ProductResponse.builder()
                        .title(product.getTitle())
                        .uuid(uuid)
                        .productId(product.getId()).build());
            }
            return listOfProducts;
        }
        return new ArrayList<>();
    }
}
