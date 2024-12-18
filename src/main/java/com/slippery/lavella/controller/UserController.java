package com.slippery.lavella.controller;

import com.slippery.lavella.dto.UserDto;
import com.slippery.lavella.models.User;
import com.slippery.lavella.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/auth")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping("/register")
    public ResponseEntity<UserDto> createNewUser(@RequestBody User userDetails){
        return ResponseEntity.ok(service.createNewUser(userDetails));
    }
    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody User userDetails){
        return ResponseEntity.ok(service.updateUser(userDetails));
    }
}
