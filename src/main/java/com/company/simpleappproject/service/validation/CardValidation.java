package com.company.simpleappproject.service.validation;

import com.company.simpleappproject.dto.CardDto;
import com.company.simpleappproject.dto.ErrorDto;
import com.company.simpleappproject.repository.CardRepository;
import com.company.simpleappproject.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CardValidation {

    private final UsersRepository usersRepository;
    private final CardRepository cardRepository;


    public List<ErrorDto> cardValid(CardDto dto) {
        List<ErrorDto> errors = new ArrayList<>();
        if (this.cardRepository.existsByCardNumberAndDeletedAtIsNull(dto.getCardNumber())){
            errors.add(new ErrorDto("cardNumber",String.format("this %s card number already exist!",dto.getCardNumber())));
        }
        if (!this.usersRepository.existsByIdAndDeletedAtIsNull(dto.getUserId())){
            errors.add(new ErrorDto("userId",String.format("User with %d id is not found!",dto.getUserId())));
        }
        return errors;
    }
}
