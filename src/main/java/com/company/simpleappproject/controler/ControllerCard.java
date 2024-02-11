package com.company.simpleappproject.controler;

import com.company.simpleappproject.dto.ApiResponse;
import com.company.simpleappproject.dto.CardDto;
import com.company.simpleappproject.service.CardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "card")
public class ControllerCard {

    private final CardService cardService;

    @PostMapping
    public ApiResponse<CardDto> createCard(@RequestBody CardDto dto) throws JsonProcessingException {
        return this.cardService.createCard(dto);
    }

    @GetMapping
    public ApiResponse<CardDto>getCardByCardId(@RequestParam(value = "id")Integer cardId){
        return this.cardService.getCard(cardId);
    }

    @PutMapping
    public ApiResponse<CardDto>updateCardByCardId(
            @RequestParam(value = "id") Integer cardId ,@RequestBody CardDto dto){
        return this.cardService.updateCard(cardId,dto);
    }
}
