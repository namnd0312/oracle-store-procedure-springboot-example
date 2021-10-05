package com.namnd.store_procedure_example.controller;

import com.namnd.store_procedure_example.dto.ProductDto;
import com.namnd.store_procedure_example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

/**
 * @author nam.nd
 * @created 15/09/2021 - 12:22 AM
 */

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("api/aaa")
    ResponseEntity<?> getStore() throws SQLException {
        List<ProductDto> products = this.productService.selectStore();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
