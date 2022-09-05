package com.springboot.reactive.controllers;

import com.springboot.reactive.dto.ProductDto;
import com.springboot.reactive.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ProductController.ROOT_PATH)
public class ProductController {

    public static final String ROOT_PATH = "/v1/products";
    @Autowired
    private ProductService productService;

    @GetMapping("all")
    public Flux<ProductDto> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("{id}")
    public Mono<ProductDto> getProductById(@PathVariable("id") String productId){
        return productService.getProduct(productId);
    }

    @PostMapping
    public Mono<ProductDto> getProductById(@RequestBody ProductDto productDto){
        return productService.saveProduct(Mono.just(productDto));
    }
}
