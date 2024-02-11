package com.company.simpleappproject.service.validation;


import com.company.simpleappproject.dto.ErrorDto;
import com.company.simpleappproject.dto.ProductDto;
import com.company.simpleappproject.service.UsersService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidation {
    @Lazy
    @Autowired
    private UsersService usersService;

    //        if (this.usersService.getUsers(dto.getProd_Id())==null){
//            return ApiResponse.<ProductDto>builder()
//                    .code(-1)
//                    .massage(String.format("User with %d id is not found",dto.getProd_Id()))
//                    .build();
//        }

    public List<ErrorDto> prodPostValidation(ProductDto dto) {
        List<ErrorDto>errors=new ArrayList<>();

        if (StringUtils.isBlank(dto.getProd_Name())){
            errors.add(new ErrorDto("prodName","ProdName cannot be null or empty"));
        } if (StringUtils.isBlank(dto.getProd_Color())){
            errors.add(new ErrorDto("prodColor","ProdColor cannot be null or empty"));
        } if (dto.getProd_Price()==null){
            errors.add(new ErrorDto("prodPrice","ProdPrice cannot be null or empty"));
        } if (dto.getUserId()==null){
            errors.add(new ErrorDto("UserId","UserId cannot be null"));
        }

        if (dto.getUserId() != null) {
            if (this.usersService.getUsers(dto.getUserId()).getContent() == null) {
                errors.add(new ErrorDto("UserId", String.format("User with %d id is not found!", dto.getUserId())));
            }
        }
        return errors;
    }
}
