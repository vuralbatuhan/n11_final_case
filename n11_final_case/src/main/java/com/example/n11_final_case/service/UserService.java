package com.example.n11_final_case.service;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUser();
    UserDto createUser(UserDto user);
    UserDto updateUser(int id, UserDto user);
    UserDto deleteUser(int id);
}
