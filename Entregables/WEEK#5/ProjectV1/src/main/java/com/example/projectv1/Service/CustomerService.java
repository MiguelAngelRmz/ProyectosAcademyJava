package com.example.projectv1.Service;

import com.example.projectv1.Entity.Customer;
import com.example.projectv1.Repo.CustomerRepo;

// import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;


@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    //new register client

    public Customer createCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    //get all the existed clients

    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepo.findById(id);
    }
    
}
