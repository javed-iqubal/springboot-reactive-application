package com.springboot.reactive.utils;

import com.springboot.reactive.dto.ProductDto;
import com.springboot.reactive.models.Product;
import org.springframework.beans.BeanUtils;

public class ProductUtils {

    public static Product dtoToModel(ProductDto productDto){
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        return product;
    }

    public static ProductDto modelToDto(Product product){
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        return productDto;
    }
}
