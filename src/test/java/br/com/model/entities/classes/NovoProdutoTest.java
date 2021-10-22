package br.com.model.entities.classes;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.entities.classes.NovoProduto;

public class NovoProdutoTest {
    @Test
    void testNovoProduto() {
        System.out.println(NovoProduto.novoProduto().toString());
    }

    @Test
    void testNovoProduto2() {
        System.out.println(NovoProduto.novoProduto2().toString());
    }
}
