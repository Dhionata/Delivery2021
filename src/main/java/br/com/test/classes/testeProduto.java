package br.com.test.classes;

import br.com.entities.classes.Produto;

public class testeProduto {
    public static void main(String[] args) {
        Produto produto = new Produto("Abacate");
        
        // Adicionar uma lista de fornecedores após a instância do mesmo.
        System.out.println(produto.toString());
    }
}
