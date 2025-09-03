package com.produtinhos.produtinhos.model;

import java.math.BigInteger;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.produtinhos.produtinhos.dto.ProdutoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Produto {
    // mapeamento de api -> create
    public Produto(ProdutoDTO dto) {
        setName(dto.getName());
        setPrice(dto.getPrice());
    }

    // mapeamento de api -> update
    public Produto(Produto produto, ProdutoDTO dto) {
        setId(produto.getId());
        setName(dto.getName());
        setPrice(dto.getPrice());
    }

    // mapeamento de mvc -> create
    public Produto(Produto produto) {
        setName(produto.getName());
        setPrice(produto.getPrice());
    }

    // mapeamento de mvc -> update
    public Produto(Long id, Produto produto) {
        setId(id);
        setName(produto.getName());
        setPrice(produto.getPrice());
        // Preservar o createdAt original
        setCreatedAt(produto.getCreatedAt());
        setUpdatedAt(produto.getUpdatedAt());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigInteger price;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @PrePersist
    void onCreate() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        setCreatedAt(now);
        setUpdatedAt(now);
    }

    @PreUpdate
    void onUpdate() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        setUpdatedAt(now);
    }
}
