package com.slippery.lavella.controller;

import com.slippery.lavella.dto.ImageAndMediaDto;
import com.slippery.lavella.service.ImageAndMediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin
public class ImageAndMediaController {
    private final ImageAndMediaService service;

    public ImageAndMediaController(ImageAndMediaService service) {
        this.service = service;
    }
    @PostMapping(value = "/create/post")
    public ResponseEntity<ImageAndMediaDto> createNewImageMedia(@RequestPart MultipartFile image,
                                                                @RequestParam Long userId,
                                                                @RequestParam String caption
    ) throws IOException{
        return ResponseEntity.ok(service.createNewImageMedia(image, userId,caption));
    }
    @GetMapping("/get/post")
    public ResponseEntity<ImageAndMediaDto> getImageById(@RequestParam Long id, @RequestParam Long userId){
        return ResponseEntity.ok(service.getImageById(id, userId));
    }
    @DeleteMapping("/delete/id")
    public ResponseEntity<ImageAndMediaDto> deleteImageById(@RequestParam Long id, @RequestParam Long userId){
        return ResponseEntity.ok(service.deleteImageById(id, userId));
    }
    @GetMapping("/get/all")
    public ResponseEntity<ImageAndMediaDto> getAllImages(@RequestParam Long userId){
        return ResponseEntity.ok(service.getAllImages(userId));
    }

}
