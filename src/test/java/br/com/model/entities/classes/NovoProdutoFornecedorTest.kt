package br.com.model.entities.classes

import br.com.newObjects.model.entities.classes.NovoProdutoFornecedor
import org.junit.jupiter.api.Test

class NovoProdutoFornecedorTest {
    @Test
    fun testNovaListaProdutosFornecedor() {
        println(NovoProdutoFornecedor.novaListaProdutosFornecedor().toString())
    }
}
