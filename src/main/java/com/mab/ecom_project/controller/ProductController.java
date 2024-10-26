package com.mab.ecom_project.controller;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {

    @RequestMapping("/")
    public String greeting(){
        return "Hello world from ProductController !";
    }
}
