package com.natived.restservice.myrestapp.services;

import com.natived.restservice.myrestapp.domain.Product;

import java.util.List;

public interface ProductService {

    Product findProductById(Integer id);

    List<Product> findAllProducts();

    Product saveProduct(Product product);

    void deleteProductByProductId(Integer id);

}

