package com.company.simpleappproject.module;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="products")
public  class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prod_Id;
    private String prod_Name;
    private String prod_Color;
    private Integer prod_Price;
    private Integer userId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
