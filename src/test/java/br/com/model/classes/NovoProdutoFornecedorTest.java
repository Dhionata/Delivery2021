package br.com.model.classes;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.classes.NovoFornecedor;
import br.com.newObjects.model.classes.NovoProdutoFornecedor;

public class NovoProdutoFornecedorTest {
    @Test
    void testNovaListaProdutosFornecedor() {
        System.out
                .println(NovoProdutoFornecedor.novaListaProdutosFornecedor(NovoFornecedor.novoFornecedor()).toString());
    }
}
