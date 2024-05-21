package org.sid.projectue.services;

import org.sid.projectue.entities.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<Product> findProductByName(String name, int page, int size);
    Product getProduct(Long id);
    void modifyProduct(Long id, Product product);
    void addProduct(Product product);
    void deleteProduct(Long id);
}
