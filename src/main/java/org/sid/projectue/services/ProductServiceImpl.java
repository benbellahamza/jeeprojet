package org.sid.projectue.services;

import org.sid.projectue.entities.Product;
import org.sid.projectue.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findProductByName(String name, int page, int size) {
        return productRepository.findByNameContaining(name, PageRequest.of(page, size));
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void modifyProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            productRepository.save(product);
        }
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
