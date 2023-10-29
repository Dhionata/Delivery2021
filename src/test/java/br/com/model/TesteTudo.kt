package br.com.model

import br.com.newObjects.model.NovoPedido
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TesteTudo {
    @Test
    fun testeTudo() {
        println(NovoPedido.novoPedido().toString())
    }
}
