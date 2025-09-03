package com.produtinhos.produtinhos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.produtinhos.produtinhos.dto.AppUserDTO;
import com.produtinhos.produtinhos.model.AppUser;
import com.produtinhos.produtinhos.repository.AppUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserService {
    private final AppUserRepository appUserRepository;

    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    public AppUser findById(Long id) {
        return appUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));
    }

    public AppUser findByEmail(String email) {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));
    }

    public AppUser save(AppUserDTO dto) {
        AppUser appUser = new AppUser(dto);
        return appUserRepository.save(appUser);
    }

    public AppUser update(Long id, AppUserDTO dto) {
        AppUser appUser = findById(id);
        AppUser novoAppUser = new AppUser(appUser, dto);
        return appUserRepository.save(novoAppUser);
    }

    public void delete(Long id) {
        AppUser appUser = findById(id);
        appUserRepository.delete(appUser);
    }
}
