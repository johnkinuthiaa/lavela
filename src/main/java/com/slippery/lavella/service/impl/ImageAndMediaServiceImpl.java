package com.slippery.lavella.service.impl;

import com.slippery.lavella.dto.ImageAndMediaDto;
import com.slippery.lavella.models.ImagesAndMedia;
import com.slippery.lavella.models.User;
import com.slippery.lavella.repository.ImageAndMediaRepository;
import com.slippery.lavella.repository.UserRepository;
import com.slippery.lavella.service.ImageAndMediaService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ImageAndMediaServiceImpl implements ImageAndMediaService {
    private final ImageAndMediaRepository repository;
    private final UserRepository userRepository;

    public ImageAndMediaServiceImpl(ImageAndMediaRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public ImageAndMediaDto createNewImageMedia(MultipartFile image,Long userId,String caption) throws IOException {
        ImageAndMediaDto response =new ImageAndMediaDto();
        ImagesAndMedia media =new ImagesAndMedia();
        Optional<User> user =userRepository.findById(userId);
        if(user.isEmpty()){
            response.setMessage("USER WAS NOT FOUND SO THE POST WASN'T CREATED");
            response.setStatusCode(404);
            return response;
        }

        media.setImageLikes(BigInteger.valueOf(0));
        media.setImageName(image.getOriginalFilename());
        media.setImageType(image.getContentType());
        media.setPosts(image.getBytes());
        media.setPostCaption(caption.strip());
        media.setUser(user.get());
        repository.save(media);

        response.setMessage("new post created");
        response.setStatusCode(404);
        return response;
    }

    @Override
    public ImageAndMediaDto getImageById(Long id, Long userId) {
        ImageAndMediaDto response =new ImageAndMediaDto();
        Optional<User> user =userRepository.findById(userId);
        Optional<ImagesAndMedia> post =repository.findById(id);
        if(user.isEmpty()){
            response.setMessage("user not found");
            response.setStatusCode(204);
            return response;
        }
        if(post.isEmpty() || !Objects.equals(post.get().getUser().getId(), userId)){
            response.setMessage("post not found");
            response.setStatusCode(204);
            return response;
        }
        response.setImageAndMedia(post.get());
        response.setMessage("post with id"+id);
        response.setStatusCode(200);
        return response;
    }

    @Override
    public ImageAndMediaDto deleteImageById(Long id, Long userId) {
        ImageAndMediaDto response =new ImageAndMediaDto();
        Optional<User> user =userRepository.findById(userId);
        Optional<ImagesAndMedia> post =repository.findById(id);
        if(user.isEmpty()){
            response.setMessage("user not found");
            response.setStatusCode(204);
            return response;
        }
        if(post.isEmpty() || !Objects.equals(post.get().getUser().getId(), userId)){
            response.setMessage("post not found");
            response.setStatusCode(204);
            return response;
        }
        repository.deleteById(id);
        response.setMessage("post deleted");
        response.setStatusCode(204);
        return response;
    }

    @Override
    public ImageAndMediaDto getAllImages(Long userId) {
        ImageAndMediaDto response =new ImageAndMediaDto();
        Optional<User> user =userRepository.findById(userId);
        if(user.isEmpty()){
            response.setMessage("user not found");
            response.setStatusCode(204);
            return response;
        }
        response.setImagesAndMediaList(repository.findAll().stream().filter(imagesAndMedia -> imagesAndMedia.getUser().getId().equals(userId)).toList());
        response.setMessage("posts for user"+user.get().getUsername());
        response.setStatusCode(200);
        return response;
    }
}
