package com.mab.ecom_project.controller;

import com.mab.ecom_project.model.Product;
import com.mab.ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){
        Product product = service.getProductById(id);

        if (product!=null)
            return new ResponseEntity<>(product,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart Product product){

        Product product1 = service.updateProduct(id,product);
        if(product1 != null)
            return new ResponseEntity<>("Product updated successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed to updat",HttpStatus.BAD_REQUEST);


    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id){

        Product  product = service.getProductById(id);
        if (product!=null) {
            service.deleteProductById(id);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        }
        else  return new ResponseEntity<>("Failed to delete. Product not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping("/product/search")
    public ResponseEntity<List<Product>> searchProductByName(@RequestParam String keyword){
        System.out.println("searching with : " + keyword);
        List<Product> products = service.searchProducts(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}
