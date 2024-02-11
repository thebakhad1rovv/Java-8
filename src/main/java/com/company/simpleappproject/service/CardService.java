package com.company.simpleappproject.service;

import com.company.simpleappproject.dto.ApiResponse;
import com.company.simpleappproject.dto.CardDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface CardService {
    ApiResponse<CardDto> createCard(CardDto dto) throws JsonProcessingException;

    ApiResponse<CardDto> getCard(Integer cardId);

    ApiResponse<CardDto> updateCard(Integer cardId, CardDto dto);
}
