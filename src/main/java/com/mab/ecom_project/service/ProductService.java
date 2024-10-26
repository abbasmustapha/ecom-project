package com.mab.ecom_project.service;

import com.mab.ecom_project.model.Product;
import com.mab.ecom_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
