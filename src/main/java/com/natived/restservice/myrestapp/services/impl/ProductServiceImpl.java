package com.natived.restservice.myrestapp.services.impl;

import com.natived.restservice.myrestapp.domain.Product;
import com.natived.restservice.myrestapp.repositories.ProductRepository;
import com.natived.restservice.myrestapp.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findProductByProductId(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductByProductId(Integer id) {
        productRepository.deleteById(id);
    }
}
