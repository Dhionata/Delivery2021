package br.com.model.entities.classes

import br.com.newObjects.model.entities.classes.usuario.NovoFornecedor
import org.junit.jupiter.api.Test

class NovoTelefoneTest {
    @Test
    fun testNovaListaTelefone() {
        val fornecedor = NovoFornecedor.novoFornecedor()
        println(fornecedor!!.telefones)
    }
}
