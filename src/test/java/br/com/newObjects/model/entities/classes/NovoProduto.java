package br.com.newObjects.model.entities.classes;

import br.com.model.entities.classes.Produto;

public class NovoProduto {

    public static Produto novoProduto() {
        return new Produto("Abacate");
    }

    public static Produto novoProduto2() {
        return new Produto("Chocolate");
    }
}
