package com.slippery.lavella.service;

import com.slippery.lavella.dto.ProfileInfoDto;
import com.slippery.lavella.models.ProfileInfo;

public interface ProfileInfoService {
    ProfileInfoDto createNewProfile(ProfileInfo profileInfo,Long userId);
}
