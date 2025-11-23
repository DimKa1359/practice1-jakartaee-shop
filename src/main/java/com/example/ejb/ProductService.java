package com.example.ejb;

import com.example.entities.Product;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long id);
}