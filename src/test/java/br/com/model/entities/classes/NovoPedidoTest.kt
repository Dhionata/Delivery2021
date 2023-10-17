package br.com.model.entities.classes

import br.com.newObjects.model.entities.classes.NovoPedido
import org.junit.jupiter.api.Test

class NovoPedidoTest {
    @Test
    fun testNovoPedido() {
        println(NovoPedido.novoPedido().toString())
    }
}
