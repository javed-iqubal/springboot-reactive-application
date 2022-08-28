package com.springboot.reactive.services;

import com.springboot.reactive.dto.ProductDto;
import com.springboot.reactive.repositories.ProductRepository;
import com.springboot.reactive.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Flux<ProductDto> getProducts(){
        return productRepository.findAll().map(ProductUtils::modelToDto);
    }
    public Mono<ProductDto> getProduct(String productId){
        return productRepository.findById(productId).map(ProductUtils::modelToDto);
    }

    public Flux<ProductDto> getProductBetweenRange(double minPrice, double maxPrice){
        return productRepository.findByPriceBetween(Range.closed(minPrice,maxPrice));
    }

    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDto ){
        return productDto.map(ProductUtils::dtoToModel)
                .flatMap(productRepository::insert )
                .map(ProductUtils::modelToDto);
    }
}
