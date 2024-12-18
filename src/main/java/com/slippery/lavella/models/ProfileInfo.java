package com.slippery.lavella.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    private String location;
    @Lob
    private String occupation;
    @ElementCollection
    private List<String> Interests;
    private String description;
    private String bio;
    @OneToOne
    private User user;


}
