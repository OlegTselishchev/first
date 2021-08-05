package com.netcracker.first.controller;

import com.netcracker.first.model.Customer;
import com.netcracker.first.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customerAll")
    public List<Customer> getAll(){
        return customerService.showAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getById(@PathVariable(name = "id") Integer id){
        return customerService.showById(id);
    }

    @PostMapping("/customer")
    public Customer create(@RequestBody Customer customer){
        return customerService.creat(customer);
    }

    @DeleteMapping("customer/{id}")
    public void delete(@PathVariable(name = "id")  Integer id){
        customerService.deleteCustomer(id);
    }
}
