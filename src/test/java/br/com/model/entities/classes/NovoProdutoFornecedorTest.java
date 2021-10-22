package br.com.model.entities.classes;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.entities.classes.NovoProdutoFornecedor;

public class NovoProdutoFornecedorTest {
    @Test
    void testNovaListaProdutosFornecedor() {
        System.out.println(NovoProdutoFornecedor.novaListaProdutosFornecedor().toString());
    }
}
