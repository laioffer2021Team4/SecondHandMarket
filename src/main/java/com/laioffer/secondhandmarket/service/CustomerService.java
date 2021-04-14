package com.laioffer.secondhandmarket.service;

import com.laioffer.secondhandmarket.entity.Address;
import com.laioffer.secondhandmarket.entity.AddressType;
import com.laioffer.secondhandmarket.entity.Customer;
import com.laioffer.secondhandmarket.entity.User;
import com.laioffer.secondhandmarket.payload.request.SignupRequest;
import com.laioffer.secondhandmarket.repository.CustomerRepository;
import com.laioffer.secondhandmarket.repository.TypeRepository;
import com.laioffer.secondhandmarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TypeRepository typeRepository;

    public void createCustomer(SignupRequest signupRequest, User user) {

            customerRepository.save(Customer.builder()
                    .address(Address.builder()
                            .street(signupRequest.getStreet())
                            .city(signupRequest.getCity())
                            .states(signupRequest.getState())
                            .zipcode(signupRequest.getZipcode())
                            .type(typeRepository.findByAddressType(AddressType.Billing)
                                    .orElseThrow(() -> new RuntimeException("Didn't find Address Type: " + AddressType.Billing)))
                            .build())
                    .firstName(signupRequest.getFirstname())
                    .lastName(signupRequest.getLastname())
                    .user(user)
                    .build());

    }

    public Customer getCustomerByEmail(String email) {

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
