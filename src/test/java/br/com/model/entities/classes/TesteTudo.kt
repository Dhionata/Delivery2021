package br.com.model.entities.classes

import br.com.newObjects.model.entities.classes.NovoPedido
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TesteTudo {
    @Test
    fun testeTudo() {
        println(NovoPedido.novoPedido().toString())
    }
}
