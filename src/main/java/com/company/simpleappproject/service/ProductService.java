package com.company.simpleappproject.service;

import com.company.simpleappproject.dto.ApiResponse;
import com.company.simpleappproject.dto.ErrorDto;
import com.company.simpleappproject.dto.ProductDto;
import com.company.simpleappproject.module.Product;
import com.company.simpleappproject.service.mapper.ProductMapper;
import com.company.simpleappproject.service.validation.ProductValidation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {

    private Integer prodIx;
    private final List<Product> productList;

    private final ProductMapper productMapper;


    private final ProductValidation productValidation;

    public ProductService(
                          ProductMapper productMapper,
                          ProductValidation productValidation
                          ){
        this.prodIx=0;
        this.productList=new ArrayList<>();

        this.productMapper=productMapper;
        this.productValidation=productValidation;
    }
    public ApiResponse<ProductDto> createProduct(ProductDto dto) {

        List<ErrorDto>errors=this.productValidation.prodPostValidation(dto);

        if (!errors.isEmpty()){
            return ApiResponse.<ProductDto>builder()
                    .code(-3)
                    .massage("Validation Error!")
                    .errorList(errors)
                    .build();
        }

        Product product =this.productMapper.toEntity(dto);
        product.setProd_Id(++this.prodIx);
        this.productList.add(product);

        return ApiResponse.<ProductDto>builder()
                .success(true)
                .massage(String.format("This product %d id successful created!",dto.getProd_Id()))
                .content(productMapper.toDto(product))
                .build();
    }

    public ApiResponse<ProductDto> getProduct(Integer prodId) {
        for (Product product : this.productList) {
            if (product.getProd_Id().equals(prodId)) {
                return ApiResponse.<ProductDto>builder()
                        .success(true)
                        .massage("ok")
                        .content(this.productMapper.toDto(product))
                        .build();
            }
        }

        return ApiResponse.<ProductDto>builder()
                .code(-1)
                .massage(String.format("Product with %d id is not found!",prodId))
                .build();
    }
    public List<ProductDto> getAllProductByUserId(Integer userId){
        List<ProductDto>products=new ArrayList<>();
        for (Product product : this.productList) {
            if (product.getProd_Id().equals(userId));
            ApiResponse<ProductDto> response =new ApiResponse<>();
            response.setSuccess(true);
            response.setMassage("OK");
            products.add(this.productMapper.toDto(product));
        }
        ApiResponse<ProductDto> response=new ApiResponse<>();
        response.setCode(-1);
        response.setMassage(String.format("No product related to the user with %d id was found!",userId ));
        return products;
    }
}
