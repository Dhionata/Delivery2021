package br.com.model

import br.com.newObjects.model.NovoProduto
import org.junit.jupiter.api.Test

class NovoProdutoTest {
    @Test
    fun testNovoProduto() {
        println(NovoProduto.novoProduto().toString())
    }

    @Test
    fun testNovoProduto2() {
        println(NovoProduto.novoProduto2().toString())
    }
}
