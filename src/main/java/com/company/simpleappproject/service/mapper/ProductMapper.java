package com.company.simpleappproject.service.mapper;


import com.company.simpleappproject.dto.ProductDto;
import com.company.simpleappproject.module.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    public Product toEntity(ProductDto dto) {

        return Product.builder()
                .prod_Name(dto.getProd_Name())
                .prod_Color(dto.getProd_Color())
                .prod_Price(dto.getProd_Price())
                .userId(dto.getUserId())
                .build();
    }


    public ProductDto toDto(Product product) {
    return ProductDto.builder()
            .prod_Name(product.getProd_Name())
            .prod_Color(product.getProd_Color())
            .prod_Price(product.getProd_Price())
            .userId(product.getUserId())
            .build();
    }

    public List<ProductDto> convertToProductDto(List<Product>productList){
        List<ProductDto>productDtoList=new ArrayList<>();
        for (Product product : productList) {
            productDtoList.add(this.toDto(product));
        }
        return productDtoList;
    }
}
