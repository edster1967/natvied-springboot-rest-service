package com.natived.restservice.myrestapp.controllers;

import com.natived.restservice.myrestapp.domain.Product;
import com.natived.restservice.myrestapp.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductByProductId(@PathVariable Integer id){
        return productService.findProductById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody  Product product){
        return productService.saveProduct(product);
    }


    @PutMapping("/{productId}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Integer productId){
        Product existingProduct = productService.findProductById(productId);
        product.setProductId(productId);

        return productService.saveProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Integer productId){
        productService.deleteProductByProductId(productId);
    }

}
