package com.company.simpleappproject.service.mapper;

import com.company.simpleappproject.dto.CardDto;
import com.company.simpleappproject.module.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {
    public Card toEntity(CardDto dto) {
        return Card.builder()
                .cardHolder(dto.getCardHolder())
                .cardName(dto.getCardName())
                .cardNumber(dto.getCardNumber())
                .cardCode(dto.getCardCode())
                .userId(dto.getUserId())
                .build();
    }

    public CardDto toDto(Card card) {
        return CardDto.builder()
                .cardId(card.getCardId())
                .cardHolder(card.getCardHolder())
                .cardName(card.getCardName())
                .cardNumber(card.getCardNumber())
                .cardCode(card.getCardCode())
                .userId(card.getUserId())
                .createdAt(card.getCreatedAt())
                .updatedAt(card.getUpdatedAt())
                .deletedAt(card.getDeletedAt())
                .build();
    }
}
