package com.slippery.lavella.repository;

import com.slippery.lavella.models.ImagesAndMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageAndLikesRepository extends JpaRepository<ImagesAndMedia,Long> {
}
