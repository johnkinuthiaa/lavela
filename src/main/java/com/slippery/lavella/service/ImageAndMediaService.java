package com.slippery.lavella.service;

import com.slippery.lavella.dto.ImageAndMediaDto;
import com.slippery.lavella.models.ImagesAndMedia;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageAndMediaService {
    ImageAndMediaDto createNewImageMedia(MultipartFile image,Long userId,String caption) throws IOException;
    ImageAndMediaDto getImageById(Long id,Long userId);
    ImageAndMediaDto deleteImageById(Long id,Long userId);
    ImageAndMediaDto getAllImages(Long id,Long userId);
}
