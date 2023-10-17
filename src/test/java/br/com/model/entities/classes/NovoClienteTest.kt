package br.com.model.entities.classes

import br.com.newObjects.model.entities.classes.usuario.NovoCliente
import org.junit.jupiter.api.Test

class NovoClienteTest {
    @Test
    fun novoClienteTeste() {
        val cliente = NovoCliente.novoCliente()
        println(cliente.toString())
    }
}
