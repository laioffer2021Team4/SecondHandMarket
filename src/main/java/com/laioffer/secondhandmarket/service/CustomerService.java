package com.laioffer.secondhandmarket.service;

import com.laioffer.secondhandmarket.entity.Address;
import com.laioffer.secondhandmarket.entity.AddressType;
import com.laioffer.secondhandmarket.entity.Customer;
import com.laioffer.secondhandmarket.entity.User;
import com.laioffer.secondhandmarket.payload.request.SignupRequest;
import com.laioffer.secondhandmarket.repository.CustomerRepository;
import com.laioffer.secondhandmarket.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Component
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;

    public void createCustomer(SignupRequest signupRequest, User user) {

        try {

            Address address = Address.builder()
                    .street(signupRequest.getStreet())
                    .city(signupRequest.getCity())
                    .states(signupRequest.getState())
                    .zipcode(signupRequest.getZipcode())
                    .country(signupRequest.getCountry())
                    .type(AddressType.Billing)
                    .build();
            Set<Address> addressSet = new HashSet<>();
            addressSet.add(address);
            Customer customer = Customer.builder()
                    .customerPhone(signupRequest.getPhone())
                    .address(addressSet)
                    .firstName(signupRequest.getFirstname())
                    .lastName(signupRequest.getLastname())
                    .user(user)
                    .build();

            customerRepository.save(customer);

        } catch (DataAccessException e) {

            logger.error("Failed to create new customer {}", e.getMessage());

        }
    }

    public Customer getCustomer(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Didn't find Customer Data by User Email: " + email));
        return customerRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Didn't find User Data by Email: " + email));
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer with id: " + id + " does not exist"));
    }
}
