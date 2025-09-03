package com.produtinhos.produtinhos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.produtinhos.produtinhos.dto.ProdutoDTO;
import com.produtinhos.produtinhos.model.Produto;
import com.produtinhos.produtinhos.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }

    public Produto save(ProdutoDTO dto) {
        Produto produto = new Produto(dto);
        return produtoRepository.save(produto);
    }

    public Produto save(Produto produto) {
        Produto produtoNovo = new Produto(produto);
        return produtoRepository.save(produtoNovo);
    }

    public Produto update(Long id, ProdutoDTO dto) {
        Produto produto = findById(id);
        Produto produtoNovo = new Produto(produto, dto);
        return produtoRepository.save(produtoNovo);
    }

    public Produto update(Long id, Produto produto) {
        Produto produtoExistente = findById(id);
        produtoExistente.setName(produto.getName());
        produtoExistente.setPrice(produto.getPrice());
        return produtoRepository.save(produtoExistente);
    }

    public void delete(Long id) {
        Produto produto = findById(id);
        produtoRepository.delete(produto);
    }

}
