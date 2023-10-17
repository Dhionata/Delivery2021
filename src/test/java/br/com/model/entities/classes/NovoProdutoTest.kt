package br.com.model.entities.classes

import br.com.newObjects.model.entities.classes.NovoProduto
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
