package com.slippery.lavella.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImagesAndMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imageName;
    private String imageType;
    private byte[] profilePhoto;
    private byte[] posts;
    @Lob
    private String postCaption;
    private BigInteger imageLikes;
    @ManyToOne
    @JsonBackReference
    private User user;
}
