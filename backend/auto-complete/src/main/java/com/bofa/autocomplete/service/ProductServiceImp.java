package com.bofa.autocomplete.service;

import com.bofa.autocomplete.domain.Product;
import com.bofa.autocomplete.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<String> search(String keyword, int page) {
        return productRepository.search(keyword, page);
    }
}
