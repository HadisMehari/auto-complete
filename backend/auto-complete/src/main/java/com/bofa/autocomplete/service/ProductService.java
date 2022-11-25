package com.bofa.autocomplete.service;

import com.bofa.autocomplete.domain.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {
    List<String> search(String keyword, int page);

}
