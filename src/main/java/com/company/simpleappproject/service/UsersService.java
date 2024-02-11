package com.company.simpleappproject.service;

import com.company.simpleappproject.dto.ApiResponse;
import com.company.simpleappproject.dto.ErrorDto;
import com.company.simpleappproject.dto.UsersDto;
import com.company.simpleappproject.exeption.ContentNotFoundException;
import com.company.simpleappproject.module.Users;
import com.company.simpleappproject.repository.UsersRepository;
import com.company.simpleappproject.service.mapper.UsersMapper;
import com.company.simpleappproject.service.validation.UsersValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {


    private final UsersMapper usersMapper;

    private final UsersRepository usersRepository;

    private final UsersValidation usersValidation;


    public ApiResponse<UsersDto> createUsers(UsersDto dto) {
        List<ErrorDto> errors = this.usersValidation.userPostValidation(dto);
        if (!errors.isEmpty()) {
            return ApiResponse.<UsersDto>builder()
                    .code(-3)
                    .massage("Validation Error")
                    .errorList(errors)
                    .build();
        }

        Users users = this.usersMapper.toEntity(dto);
        users.setCreatedAt(LocalDateTime.now());


       /* if (isUsersAlreadyexist(users.getEmail())){
            ApiResponse<UsersDto> response= new ApiResponse<>();
            response.setCode(-1);
            response.setMassage(String.format("This %s email already Exist!",users.getEmail()));
        }
        */


        ApiResponse<UsersDto> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMassage("ok");
        response.setContent(this.usersMapper.toDto(this.usersRepository.save(users)));
        return response;
    }


    public ApiResponse<UsersDto> getUsers(Integer userId) {
        Optional<Users> optional = this.usersRepository.findByIdAndDeletedAtIsNull(userId);
        if (optional.isEmpty()) {
            throw new ContentNotFoundException(String.format("User with %d id is not found", userId));

        }
        return ApiResponse.<UsersDto>builder()
                .success(true)
                .massage("ok")
                .content(this.usersMapper.toDtoWithProduct(optional.get()))
                
                .build();
    }

    public ApiResponse<UsersDto> updateUsers(Integer userId, UsersDto dto) {

        List<ErrorDto> errors = this.usersValidation.userPutValidation(dto);
        if (!errors.isEmpty()) {
            return ApiResponse.<UsersDto>builder()
                    .code(-3)
                    .massage("Validation Error")
                    .errorList(errors)
                    .build();
        }

        Optional<Users> optional = this.usersRepository.findByIdAndDeletedAtIsNull(userId);
        if (optional.isEmpty()) {
            throw new ContentNotFoundException(String.format("User with %d id is not found", userId));
        }
        try {

            Users updatedUser = this.usersMapper.convertNewUsers(optional.get(), dto);
            updatedUser.setUpdatedAt(LocalDateTime.now());

            ApiResponse<UsersDto> response = new ApiResponse<>();
            response.setSuccess(true);
            response.setMassage(String.format("User with %d id successful updated", updatedUser.getId()));
            response.setContent(this.usersMapper.toDto(this.usersRepository.save(updatedUser)));
            return response;
        } catch (Exception e) {
            return ApiResponse.<UsersDto>builder()
                    .code(-2)
                    .massage(String.format("User while updating error! Massage %s", e.getMessage()))
                    .build();
        }

/*
        ApiResponse<UsersDto> response=new ApiResponse<>();
        response.setCode(-1);
        response.setMassage(String.format("User with %d id is not found",userId));
*/


    }


    public ApiResponse<UsersDto> deleteUsers(Integer userId) {
        Optional<Users> optional = this.usersRepository.findByIdAndDeletedAtIsNull(userId);
        if (optional.isEmpty()) {
            throw new ContentNotFoundException(String.format("User with %d id is not found", userId));
        }

        Users users = optional.get();
        users.setDeletedAt(LocalDateTime.now());

        ApiResponse<UsersDto> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMassage(String.format("User with %d id successful deleted!", users.getId()));
        response.setContent(this.usersMapper.toDto(this.usersRepository.save(users)));

       /* ApiResponse<UsersDto> response=new ApiResponse<>();
        response.setCode(-1);
        response.setMassage(String.format("User with %d id is not found",userId));*/

        return response;


    }


}
