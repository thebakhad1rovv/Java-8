package com.company.simpleappproject.dto;

import com.company.simpleappproject.module.Product;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    private Integer id;

    @NotBlank(message = "Firstname cannot be null or empty!")
    private  String first_name;

    @NotBlank(message = "Lastname cannot be null or empty!")
    private String last_name;

    @NotNull(message = "Age cannot be null")
    private Integer age;

    @Email(message = "The given value did not match the email pattern")
    @NotBlank(message = "Email cannot be null or empty!")
    private String email;

    @Size(min = 4 ,max = 10,message = "The length of the entered value must be from 4 to 10")
    @NotBlank(message = "Password cannot be null or empty!")
    private String password;

    List<ProductDto> products;


}
