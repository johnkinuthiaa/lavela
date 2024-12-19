package com.slippery.lavella.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.slippery.lavella.models.ImagesAndMedia;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageAndMediaDto {
    private String message;
    private String errorMessage;
    private Integer statusCode;
    private ImagesAndMedia imageAndMedia;
    private List<ImagesAndMedia> imagesAndMediaList;
}
