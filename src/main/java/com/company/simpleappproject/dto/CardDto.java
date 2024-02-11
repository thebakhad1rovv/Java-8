package com.company.simpleappproject.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {

    private Integer cardId;
    @NotBlank(message = "Card Holder cannot be null or empty!")
    private String cardHolder;
    @NotBlank(message = "Card Name cannot be null or empty!")
    private String cardName;
    @NotBlank(message = "Card Number cannot be null or empty!")
    private String cardNumber;
    @NotBlank(message = "Card Code cannot be null or empty!")
    private String cardCode;
    @NotNull(message = "userId cannot be null!")
    private Integer userId;

   private LocalDateTime createdAt ;
   private LocalDateTime updatedAt;
   private LocalDateTime deletedAt;

}
