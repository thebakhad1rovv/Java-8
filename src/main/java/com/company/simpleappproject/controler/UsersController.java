package com.company.simpleappproject.controler;

import com.company.simpleappproject.dto.ApiResponse;
import com.company.simpleappproject.dto.ProductDto;
import com.company.simpleappproject.dto.UsersDto;
import com.company.simpleappproject.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "users")

public class UsersController {

    private final UsersService usersService;


    @PostMapping
    public ApiResponse<UsersDto> createUsers(@RequestBody @Valid UsersDto users){
       return this.usersService.createUsers(users);
    }


    @GetMapping
    public ApiResponse<UsersDto> getUsers(@RequestParam(value = "id") Integer userId){

       return usersService.getUsers(userId);
    }

    @PutMapping
    public ApiResponse<UsersDto>  updateUsers(@RequestParam(value = "id")Integer userId,
                                                @RequestBody UsersDto newUsers){
       return usersService.updateUsers(userId,newUsers);
    }


    public ApiResponse<UsersDto>  deleteUsers(@RequestParam(value = "id")Integer userId){
        return usersService.deleteUsers(userId);
    }


    public ApiResponse<List<ProductDto>> getAllUsers(){

        return null;
    }


}
