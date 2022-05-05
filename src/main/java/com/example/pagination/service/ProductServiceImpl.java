package com.example.pagination.service;

import com.example.pagination.model.PaginationResponse;
import com.example.pagination.model.Product;
import com.example.pagination.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public PaginationResponse findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> pageResult = productRepo.findAll(pageable);

        PaginationResponse paginationResponse = new PaginationResponse();
        paginationResponse.setContent(pageResult.getContent());
        paginationResponse.setPageNumber(pageResult.getNumber());
        paginationResponse.setPageSize(pageResult.getSize());
        paginationResponse.setLast(pageResult.isLast());
        paginationResponse.setTotalPages(pageResult.getTotalPages());
        paginationResponse.setTotalElements(pageResult.getNumberOfElements());

        return paginationResponse;
    }




}
