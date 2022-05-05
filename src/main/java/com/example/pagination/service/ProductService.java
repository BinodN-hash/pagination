package com.example.pagination.service;

import com.example.pagination.model.PaginationResponse;
import com.example.pagination.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    PaginationResponse findPaginated(int pageNo, int pageSize);



}
