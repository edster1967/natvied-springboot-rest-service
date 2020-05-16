package com.natived.restservice.myrestapp.repositories;

import com.natived.restservice.myrestapp.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findProductByProductId(Integer id);
    List<Product> findAll();
    void deleteProductByProductId(Integer productId);

}

