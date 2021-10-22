package br.com.newObjects.model.entities.classes;

import br.com.model.entities.classes.Produto;

public class NovoProduto {

    // Adicionar uma lista de fornecedores após a instância do mesmo.

    public static Produto novoProduto() {
        return new Produto("Abacate");
    }

    public static Produto novoProduto2() {
        return new Produto("Chocolate");
    }
}
