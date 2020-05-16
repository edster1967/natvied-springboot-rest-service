package com.natived.restservice.myrestapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping
    public String getCustomer(){
        logger.debug("Starting getCustomer method");
        return "get customer was called";
    }

    @PostMapping
    public String createCustomer(){
        logger.debug("Starting createCustomer method");
        return "create customer was called";
    }

    @PutMapping
    public String updateCustomer(){
        logger.debug("Starting updateCustomer method");
        return "update customer was called";
    }

    @DeleteMapping
    public String deleteCustomer(){
        logger.debug("Starting deleteCustomer method");
        return "delete customer was called";
    }


}
