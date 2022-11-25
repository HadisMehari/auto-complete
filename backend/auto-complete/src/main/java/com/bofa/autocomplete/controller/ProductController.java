package com.bofa.autocomplete.controller;

import com.bofa.autocomplete.domain.Product;
import com.bofa.autocomplete.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping(value ="/search/{keyword}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> search(@PathVariable String keyword){
        try {
            return new ResponseEntity<List<String>>(productService.search(keyword, 6), HttpStatus.OK);

        } catch (Exception  ex){
            return new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
        }
    }

}
