package com.mab.ecom_project.service;

import com.mab.ecom_project.model.Product;
import com.mab.ecom_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteProductById(Integer id) {
        {
            repo.deleteById(id);

        }
    }

    public Product updateProduct(int id, Product product) {

        return repo.save(product);

    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
