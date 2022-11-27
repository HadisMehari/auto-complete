package com.bofa.autocomplete.service;


import java.util.List;

public interface CompanyService {
    List<String> search(String keyword, int page);

}
