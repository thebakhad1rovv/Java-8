package com.company.simpleappproject.controler;

import com.company.simpleappproject.dto.ApiResponse;
import com.company.simpleappproject.dto.ProductDto;
import com.company.simpleappproject.module.Product;
import com.company.simpleappproject.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class ControllerProduct {

    private final ProductService productService;

    public ControllerProduct(ProductService productService){
        this.productService=productService;
    }

    @PostMapping
    public ApiResponse<ProductDto> createProduct (@RequestBody ProductDto dto){
        return this.productService.createProduct(dto);
    }
    @GetMapping(value = "/{id}")
    public ApiResponse<ProductDto> getProduct (@PathVariable(value = "id")Integer prodId){
        return this.productService.getProduct(prodId);
    }

}
