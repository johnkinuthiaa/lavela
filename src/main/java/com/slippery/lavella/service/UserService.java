package com.slippery.lavella.service;

import com.slippery.lavella.dto.UserDto;
import com.slippery.lavella.models.User;

public interface UserService {
    UserDto createNewUser(User userDetails);
    UserDto updateUser(User userDetails);
    UserDto deleteUser(Long userId);
    UserDto getUserById(Long userId);
}
