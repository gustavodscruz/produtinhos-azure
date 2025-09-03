package com.produtinhos.produtinhos.dto;

import java.math.BigInteger;

import lombok.Data;

@Data
public class ProdutoDTO {
    private String name;
    private BigInteger price;
}
