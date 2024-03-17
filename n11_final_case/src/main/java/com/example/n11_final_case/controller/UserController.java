package com.example.n11_final_case.controller;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.dto.UserDto;
import com.example.n11_final_case.service.UserService;
import com.example.n11_final_case.util.LoggerHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/getAll")
    public List<UserDto> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto user) {
        LoggerHandler.getLogger().log(Level.INFO,
                "UserController --> createUser() --> User has been sent to UserService createUser()");
        return userService.createUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public UserDto deleteUser(@PathVariable int id) {
        LoggerHandler.getLogger().log(Level.INFO,
                "UserController --> deleteUser() --> User id has been sent to UserService deleteUser()");
        return userService.deleteUser(id);
    }

    @PutMapping("update/{id}")
    public UserDto updateUser(@PathVariable int id, @RequestBody UserDto user) {
        return userService.updateUser(id, user);
    }

}
