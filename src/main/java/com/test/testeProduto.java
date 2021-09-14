package com.test;

import com.entities.classes.Produto;

public class testeProduto {
    public static void main(String[] args) {
        Produto produto = new Produto("Abacate");
        // Adicionar fornecedor após a instância do mesmo.
        System.out.println(produto.toString());
    }
}
