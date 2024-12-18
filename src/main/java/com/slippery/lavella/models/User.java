package com.slippery.lavella.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.lang.NonNull;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer age;
    private String firstName;
    private String lastName;

    private String username;

    private String email;

    private String password;
    private LocalDateTime createdOn;
    private Boolean isLikelyACatfish =false;
    @OneToMany
    @JsonManagedReference
    private List<ImagesAndMedia> posts;
}
