package br.com.test.model.classes;

import br.com.model.entities.classes.Produto;

public class testeProduto {
    public static void main(String[] args) {

        // Adicionar uma lista de fornecedores após a instância do mesmo.
        System.out.println(novoProduto().toString());
    }

    public static Produto novoProduto() {
        return new Produto("Abacate");
    }

    public static Produto novoProduto2() {
        return new Produto("Chocolate");
    }
}
