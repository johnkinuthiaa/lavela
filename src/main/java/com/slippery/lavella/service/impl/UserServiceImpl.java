package com.slippery.lavella.service.impl;

import com.slippery.lavella.dto.UserDto;
import com.slippery.lavella.models.User;
import com.slippery.lavella.repository.UserRepository;
import com.slippery.lavella.service.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private PasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDto createNewUser(User userDetails) {
        UserDto response =new UserDto();
        var existingUser =repository.findUserByUsername(userDetails.getUsername());
        if(existingUser !=null){
            response.setErrorMessage("user with username"+userDetails.getUsername()+"already exists,consider changing your username");
            response.setStatusCode(500);
            return response;
        }
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        userDetails.setCreatedOn(LocalDateTime.now());
        repository.save(userDetails);
        response.setErrorMessage("user with username"+userDetails.getUsername()+"created");
        response.setStatusCode(200);
        return response;
    }

    @Override
    public UserDto updateUser(User userDetails) {
        UserDto response =new UserDto();
        Optional<User> user = Optional.ofNullable(repository.findUserByUsername(userDetails.getUsername()));
        if(user.isEmpty()){
            response.setErrorMessage("user with username "+userDetails.getUsername()+" not found!");
            response.setStatusCode(200);
            return response;
        }
        User existingUser =user.get();
        existingUser.setPassword(userDetails.getPassword() ==null || userDetails.getPassword().isBlank()?user.get().getPassword():userDetails.getPassword());
        existingUser.setAge(userDetails.getAge() ==null  || userDetails.getAge().toString().isBlank()?user.get().getAge():userDetails.getAge());
        existingUser.setEmail(userDetails.getEmail() ==null  || userDetails.getEmail().isBlank()?user.get().getEmail():userDetails.getEmail());
        existingUser.setUsername(userDetails.getUsername()==null  || userDetails.getUsername().isBlank()?user.get().getUsername():userDetails.getUsername());
        existingUser.setFirstName(userDetails.getFirstName() ==null  || userDetails.getFirstName().isBlank()?user.get().getFirstName():userDetails.getFirstName());
        existingUser.setLastName(userDetails.getLastName() ==null  || userDetails.getLastName().isBlank()?user.get().getLastName():userDetails.getLastName());
        existingUser.setIsLikelyACatfish(userDetails.getIsLikelyACatfish() ==null  || userDetails.getIsLikelyACatfish().toString().isBlank()?user.get().getIsLikelyACatfish(): userDetails.getIsLikelyACatfish());
        repository.save(existingUser);
        response.setErrorMessage("user with username "+userDetails.getUsername()+" updated successfully");
        response.setStatusCode(200);
//        existingUser.setAge(userDetails.getAge() ==null?1:2);

        return response;
    }

    @Override
    public UserDto deleteUser(Long userId) {
        return null;
    }

    @Override
    public UserDto getUserById(Long userId) {
        return null;
    }
}
