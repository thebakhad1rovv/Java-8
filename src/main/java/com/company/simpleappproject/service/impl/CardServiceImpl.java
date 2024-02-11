package com.company.simpleappproject.service.impl;

import com.company.simpleappproject.dto.ApiResponse;
import com.company.simpleappproject.dto.CardDto;
import com.company.simpleappproject.dto.ErrorDto;
import com.company.simpleappproject.exeption.ContentNotFoundException;
import com.company.simpleappproject.exeption.DatabaseException;
import com.company.simpleappproject.module.Card;
import com.company.simpleappproject.repository.CardRepository;
import com.company.simpleappproject.service.CardService;
import com.company.simpleappproject.service.mapper.CardMapper;
import com.company.simpleappproject.service.validation.CardValidation;
import com.company.simpleappproject.exeption.CustomValidationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardMapper cardMapper;
    private final CardValidation cardValidation;
    private final ObjectMapper objectMapper;
    private final CardRepository cardRepository;


    @Override
    public ApiResponse<CardDto> createCard(CardDto dto) throws JsonProcessingException {
        List<ErrorDto> errors=this.cardValidation.cardValid(dto);
        if (!errors.isEmpty()) {

            throw new CustomValidationException(this.objectMapper.writeValueAsString(errors));
        }
        try {


            return ApiResponse.<CardDto>builder()
                    .success(true)
                    .massage("ok")
                    .content(cardMapper.toDto(
                            cardRepository.save(
                                    cardMapper.toEntity(dto)
                            )
                    ))
                    .build();
        }catch (Exception e){
            throw new DatabaseException(String.format("Card while saving error! Message %s",e.getMessage()));
        }
    }

    @Override
    public ApiResponse<CardDto> getCard(Integer cardId) {
        Optional<Card> optional = this.cardRepository.findByCardIdAndDeletedAtIsNull(cardId);
        if (optional.isEmpty()){
            throw new  ContentNotFoundException(String.format("Card with %d id is not found!",cardId));
        }
        return ApiResponse.<CardDto>builder()
                .success(true)
                .massage("ok")
                .content(this.cardMapper.toDto(optional.get()))
                .build();
    }

    @Override
    public ApiResponse<CardDto> updateCard(Integer cardId, CardDto dto) {
        return null;
    }
}
