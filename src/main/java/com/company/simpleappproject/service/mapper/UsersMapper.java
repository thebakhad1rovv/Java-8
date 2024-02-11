package com.company.simpleappproject.service.mapper;


import com.company.simpleappproject.dto.ProductDto;
import com.company.simpleappproject.dto.UsersDto;
import com.company.simpleappproject.module.Product;
import com.company.simpleappproject.module.Users;
import com.company.simpleappproject.service.ProductService;
import com.company.simpleappproject.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersMapper {

    private final ProductService productService;

    /*public UsersMapper(ProductService productService){
        this.productService=productService;
    }*/
    public Users toEntity(UsersDto dto) {
        Users users= new Users();
        users.setFirst_name(dto.getFirst_name());
        users.setLast_name(dto.getLast_name());
        users.setAge(dto.getAge());
        users.setEmail(dto.getEmail());
        users.setPassword(dto.getPassword());
        return users;
    }
    public UsersDto toDto(Users users) {
        UsersDto dto= new UsersDto();
        dto.setId(users.getId());
        dto.setFirst_name(users.getFirst_name());
        dto.setLast_name(users.getLast_name());
        dto.setAge(users.getAge());
        dto.setEmail(users.getEmail());
        dto.setPassword(users.getPassword());
        return dto;
    }
    public UsersDto toDtoWithProduct(Users users) {
        UsersDto dto= new UsersDto();
        dto.setId(users.getId());
        dto.setFirst_name(users.getFirst_name());
        dto.setLast_name(users.getLast_name());
        dto.setAge(users.getAge());
        dto.setEmail(users.getEmail());
        dto.setPassword(users.getPassword());
        dto.setProducts(this.productService.getAllProductByUserId(users.getId()));
//        dto.setProducts(convertToProductDto(this.productService.getAllProductByUserId(users.getId())));
        return dto;
    }




    public Users convertNewUsers(Users users, UsersDto dto) {
        if (dto.getFirst_name() != null){
            users.setFirst_name(dto.getFirst_name());
        } if (dto.getLast_name() != null){
            users.setLast_name(dto.getLast_name());
        } if (dto.getEmail() != null){
            users.setEmail(dto.getEmail());
        }if (dto.getAge() != null){
            users.setAge(dto.getAge());
        }if (dto.getPassword() != null){
            users.setPassword(dto.getPassword());
        }
        return null;
    }


}
