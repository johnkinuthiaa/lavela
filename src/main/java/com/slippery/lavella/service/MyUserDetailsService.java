package com.slippery.lavella.service;

import com.slippery.lavella.models.User;
import com.slippery.lavella.models.UserPrincipal;
import com.slippery.lavella.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    public MyUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =repository.findUserByUsername(username);

        if(user ==null){
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(user);
    }
}
