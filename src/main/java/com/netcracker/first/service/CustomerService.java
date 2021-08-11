package com.netcracker.first.service;

import com.netcracker.first.model.Customer;
import com.netcracker.first.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer creat(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    public List<Customer> showAll(){
        return customerRepository.findAll();
    }

    public Customer showById(Integer id){
        return customerRepository.getById(id);
    }

    public void deleteCustomer(Integer id){
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        }
    }

    public boolean updateCustomer(Customer customer){
        if (customerRepository.existsById(customer.getId())){
            Customer customerForUpdate = customerRepository.getById(customer.getId());
            customerForUpdate.setLastName(customer.getLastName());
            customerForUpdate.setFirstName(customer.getFirstName());
            customerRepository.save(customerForUpdate);
            return true;
        }
        return false;
    }
}
