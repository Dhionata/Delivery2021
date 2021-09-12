package com.test;

import com.entities.classes.Produto;

public class testeProduto {
    public static void main(String[] args) {
        Produto produto = new Produto(1, "Abacate", 12.53F, 2);
        // Adicionar fornecedor após a instância do mesmo.
        // produto.setFornecedor(fornecedor);
        System.out.println(produto.toString());
    }
}
