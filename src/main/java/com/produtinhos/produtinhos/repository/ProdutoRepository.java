package com.produtinhos.produtinhos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtinhos.produtinhos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
