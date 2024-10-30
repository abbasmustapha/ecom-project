package com.mab.ecom_project.repository;

import com.mab.ecom_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT p from Product p WHERE " +
            "LOWER(p.name)  like lower(concat('%', :keyword, '%')) OR " +
            "LOWER(p.desc)  like lower(concat('%', :keyword, '%')) OR " +
            "LOWER(p.brand)  like lower(concat('%', :keyword, '%')) OR " +
            "LOWER(p.category)  like lower(concat('%', :keyword, '%'))"
    )
    List<Product> searchProducts(String keyword);
}
