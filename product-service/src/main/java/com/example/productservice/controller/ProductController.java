package com.example.productservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final List<String> products =
            new ArrayList<>(
                    List.of(
                            "Laptop",
                            "Keyboard",
                            "Mouse"
                    )
            );

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<String> getProducts() {
        return products;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProduct(
            @PathVariable int id
    ) {

        return "Product " + id + " deleted successfully";
    }
}