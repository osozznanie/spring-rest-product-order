package com.example.service;

import com.example.payload.ProductDto;
import com.example.payload.ProductResponse;

public interface ProductService {
    ProductDto save(ProductDto productDto);
    ProductResponse findAll(int pageNo, int pageSize, String sortBy, String sortDir);
    ProductDto findById(Long id);
    ProductDto update(ProductDto productDto, Long id);
    void deleteById(Long id);

}
