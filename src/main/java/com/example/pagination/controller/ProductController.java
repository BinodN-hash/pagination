package com.example.pagination.controller;

import com.example.pagination.model.PaginationResponse;
import com.example.pagination.model.Product;
import com.example.pagination.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public PaginationResponse getProducts(@RequestParam(value = "pageNo", required = false) int pageNo, @RequestParam (value = "pageSize", required = false) int pageSize){
        System.out.println(productService);
        return productService.findPaginated(pageNo, pageSize);
    }

}
