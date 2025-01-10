package dev.zeyu.springboot.service;

import java.util.List;
import dev.zeyu.springboot.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long id);
}
