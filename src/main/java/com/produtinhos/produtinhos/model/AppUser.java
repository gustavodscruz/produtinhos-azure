package com.produtinhos.produtinhos.model;

import com.produtinhos.produtinhos.dto.AppUserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public AppUser(AppUserDTO dto) {
        setEmail(dto.getEmail());
        setName(dto.getName());
        setPassword(dto.getPassword());
    }

    public AppUser(AppUser appUser, AppUserDTO dto) {
        setId(appUser.getId());
        setName(dto.getName());
        setEmail(dto.getEmail());
        setPassword(dto.getPassword());
    }

    private String name;
    private String email; 
    private String password;
}
