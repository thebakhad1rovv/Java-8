package com.company.simpleappproject.module;

import com.company.simpleappproject.dto.ProductDto;
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
@Table(name = ("users"))
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String first_name;
    private String last_name;
    private Integer age;
    @Column(unique = true,nullable = false)
    private String email;
    private String password;


    @OneToMany(mappedBy = "userId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private List<Card> cards;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    // List<Product>products;


}
