package com.company.simpleappproject.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private String massage;
    //todo
    // 0 it is ok
    // -1 is not found
    // -2 db error
    // -3 validation error
    // -4 eny error
    private int code;

    private T content;

    private List<ErrorDto> errorList;



}
