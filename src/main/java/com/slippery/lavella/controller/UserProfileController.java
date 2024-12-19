package com.slippery.lavella.controller;

import com.slippery.lavella.dto.ProfileInfoDto;
import com.slippery.lavella.models.ProfileInfo;
import com.slippery.lavella.service.ProfileInfoService;
import com.slippery.lavella.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
public class UserProfileController {
    private final ProfileInfoService service;

    public UserProfileController(ProfileInfoService service) {
        this.service = service;
    }
    @PostMapping("/create/profile")
    public ResponseEntity<ProfileInfoDto> createNewProfile(@RequestBody ProfileInfo profileInfo, @RequestParam Long userId){
        return ResponseEntity.ok(service.createNewProfile(profileInfo,userId));
    }
}
