package com.slippery.lavella.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.slippery.lavella.models.ProfileInfo;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileInfoDto {
    private String message;
    private String errorMessage;
    private int statusCode;
    private ProfileInfo profile;
    public List<ProfileInfo> profileInfoList;
}
