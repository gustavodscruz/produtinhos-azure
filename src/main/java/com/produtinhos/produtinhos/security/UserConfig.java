package com.produtinhos.produtinhos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.produtinhos.produtinhos.model.AppUser;
import com.produtinhos.produtinhos.service.AppUserService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class UserConfig {

    private final AppUserService appUserService;

    @Bean
    UserDetailsService generateUser() {
        return username -> {
            AppUser appUser = appUserService.findByEmail(username);
            return User.builder().username(appUser.getEmail())
                    .password(appUser.getPassword())
                    .roles("USER")
                    .build();
        };
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
