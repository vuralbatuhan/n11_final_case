package com.example.n11_final_case.service;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.dao.UserDao;
import com.example.n11_final_case.dto.UserDto;
import com.example.n11_final_case.entity.User;
import com.example.n11_final_case.exception.UserNotFoundException;
import com.example.n11_final_case.util.LoggerHandler;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    private final ModelMapper modelMapper;


    public List<UserDto> getAllUser() {
        List<User> userList = userDao.getAllUser();
        List<UserDto> userDtoList = userList.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtoList;
    }

    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        LoggerHandler.getLogger().log(Level.INFO,
                "UserServiceImpl --> createUser() --> New user has been created");
        return modelMapper.map(userDao.save(user), UserDto.class);
    }

    public UserDto deleteUser(int id) {
        User user = userDao.findById(id).orElseThrow(() -> new UserNotFoundException("There is no such user. Check user id"));
        userDao.delete(userDao.getById(id));
        LoggerHandler.getLogger().log(Level.INFO,
                "UserServiceImpl --> deleteUser() --> User deleted by id");
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto updateUser(int id, UserDto user) {
        Optional<User> resultUser = Optional.ofNullable(userDao.findById(id).orElseThrow(() -> new UserNotFoundException("There is no such user. Check user id")));
        if(resultUser.isPresent()) {
            resultUser.get().setId(user.getId());
            resultUser.get().setName(user.getName());
            resultUser.get().setSurname(user.getSurname());
            resultUser.get().setAge(user.getAge());
            resultUser.get().setLatitude(user.getLatitude());
            resultUser.get().setLongitude(user.getLongitude());
            LoggerHandler.getLogger().log(Level.INFO,
                    "UserServiceImpl --> updateUser() --> User updated by id");

            return modelMapper.map(userDao.save(resultUser.get()), UserDto.class);

        }else {
            return null;
        }

    }



}
