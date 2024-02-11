package com.company.simpleappproject.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Integer prod_Id;
    private String prod_Name;
    private String prod_Color;
    private Integer prod_Price;

    private Integer userId;

}
