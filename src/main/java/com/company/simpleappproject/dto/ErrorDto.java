package com.company.simpleappproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.SplittableRandom;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ErrorDto {
    private String fieldName;
    private String message;

}
