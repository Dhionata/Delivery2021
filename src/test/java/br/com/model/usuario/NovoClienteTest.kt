package br.com.model.usuario

import br.com.newObjects.model.usuario.NovoCliente
import org.junit.jupiter.api.Test

class NovoClienteTest {
    @Test
    fun novoClienteTeste() {
        val cliente = NovoCliente.novoCliente()
        println(cliente.toString())
    }
}
