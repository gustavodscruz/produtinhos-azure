package com.produtinhos.produtinhos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtinhos.produtinhos.model.AppUser;
import java.util.Optional;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
