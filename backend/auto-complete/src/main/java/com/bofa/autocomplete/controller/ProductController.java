package com.bofa.autocomplete.controller;

import com.bofa.autocomplete.domain.Product;
import com.bofa.autocomplete.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/product")
@Validated
public class ProductController {
    @Autowired
    ProductService productService;

    @Value("${return.options}")
    private int returnedOptions;

    @GetMapping(value ="/search/{keyword}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> search(@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]{2,}$") @PathVariable  String keyword){
        try {
            return new ResponseEntity<List<String>>(productService.search(keyword, returnedOptions), HttpStatus.OK);

        } catch (Exception  ex){
            return new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
        }
    }

}
