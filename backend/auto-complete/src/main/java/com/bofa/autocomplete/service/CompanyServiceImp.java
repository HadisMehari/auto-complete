package com.bofa.autocomplete.service;

import com.bofa.autocomplete.domain.Company;
import com.bofa.autocomplete.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CompanyServiceImp implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public List<String> search(String keyword, int page) {


        return  companyRepository.search(keyword, page);

    }
}
