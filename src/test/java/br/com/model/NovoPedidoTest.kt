package br.com.model

import br.com.newObjects.model.NovoPedido
import org.junit.jupiter.api.Test

class NovoPedidoTest {
    @Test
    fun testNovoPedido() {
        println(NovoPedido.novoPedido().toString())
    }
}
