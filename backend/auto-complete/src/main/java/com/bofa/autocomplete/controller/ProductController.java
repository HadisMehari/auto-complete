package com.bofa.autocomplete.controller;

import com.bofa.autocomplete.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/company")
@Validated
public class ProductController {
    @Autowired
    CompanyService companyService;

    @Value("${return.options}")
    private int returnedOptions;

    @GetMapping(value ="/search/{keyword}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> search(@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]{2,}$") @PathVariable  String keyword){
            return new ResponseEntity<List<String>>(companyService.search(keyword, returnedOptions), HttpStatus.OK);
    }

}
