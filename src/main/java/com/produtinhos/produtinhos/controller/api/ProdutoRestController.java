package com.produtinhos.produtinhos.controller.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtinhos.produtinhos.dto.ProdutoDTO;
import com.produtinhos.produtinhos.model.Produto;
import com.produtinhos.produtinhos.service.ProdutoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/produto")
public class ProdutoRestController {
    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
        return ResponseEntity.ok(produtoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
