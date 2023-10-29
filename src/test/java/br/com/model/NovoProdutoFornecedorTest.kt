package br.com.model

import br.com.newObjects.model.NovoProdutoFornecedor
import org.junit.jupiter.api.Test

class NovoProdutoFornecedorTest {
    @Test
    fun testNovaListaProdutosFornecedor() {
        println(NovoProdutoFornecedor.novaListaProdutosFornecedor().toString())
    }
}
