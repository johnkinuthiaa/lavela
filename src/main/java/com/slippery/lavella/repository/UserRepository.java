package com.slippery.lavella.repository;

import com.slippery.lavella.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsername(String username);
}
