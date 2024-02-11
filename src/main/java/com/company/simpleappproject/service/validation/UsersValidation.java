package com.company.simpleappproject.service.validation;

import com.company.simpleappproject.dto.ErrorDto;
import com.company.simpleappproject.dto.UsersDto;
import com.company.simpleappproject.repository.UsersRepository;
import com.company.simpleappproject.service.UsersService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersValidation {
    private final UsersRepository usersRepository;

    public List<ErrorDto> userPostValidation(UsersDto dto) {
        List<ErrorDto>errors= new ArrayList<>();
        if (this.usersRepository.existsByEmailAndDeletedAtIsNull(dto.getEmail())){
            errors.add(new ErrorDto("email",String.format("This email %s already exist!",dto.getEmail())));
        }
    return errors;

    }

    public List<ErrorDto> userPutValidation(UsersDto dto) {
        List<ErrorDto>errors =new ArrayList<>();
        if (dto.getEmail()!=null) {
            if (this.usersRepository.existsByEmailAndDeletedAtIsNull(dto.getEmail())) {
                errors.add(new ErrorDto("email",String.format("%s email already exist!",dto.getEmail())));
            }
        }
        return errors;
    }
}
