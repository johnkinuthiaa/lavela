package com.slippery.lavella.service.impl;

import com.slippery.lavella.dto.ProfileInfoDto;
import com.slippery.lavella.models.ProfileInfo;
import com.slippery.lavella.models.User;
import com.slippery.lavella.repository.ProfileInfoRepository;
import com.slippery.lavella.repository.UserRepository;
import com.slippery.lavella.service.ProfileInfoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileInfoServiceImpl implements ProfileInfoService {
    private final ProfileInfoRepository repository;
    private final UserRepository userRepository;

    public ProfileInfoServiceImpl(ProfileInfoRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public ProfileInfoDto createNewProfile(ProfileInfo profileInfo,Long userId) {
        ProfileInfoDto response =new ProfileInfoDto();
        Optional<User> user =userRepository.findById(userId);
        if(user.isEmpty()){
            response.setErrorMessage("user not found");
            response.setStatusCode(404);
        }
        var existingProfile = repository.findAll().stream().filter(profileInfo1 -> profileInfo1.getUser().equals(user.get()))
                .toList();
        if(existingProfile.isEmpty()){
            ProfileInfo profile =new ProfileInfo();
            profile.setBio(profileInfo.getBio());
            profile.setDescription(profileInfo.getDescription());
            profile.setInterests(profileInfo.getInterests());
            profile.setLocation(profileInfo.getLocation());
            profile.setOccupation(profileInfo.getOccupation());
            profile.setUser(user.get());
            repository.save(profile);
            response.setMessage("user profile created");
            response.setStatusCode(200);
            response.setProfile(profile);
        }
        else{
            response.setErrorMessage("user already has a profile");
            response.setStatusCode(200);

            return response;
        }
        return response;
    }
}
