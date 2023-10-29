package br.com.model

import br.com.newObjects.model.usuario.NovoFornecedor
import org.junit.jupiter.api.Test

class NovoTelefoneTest {
    @Test
    fun testNovaListaTelefone() {
        val fornecedor = NovoFornecedor.novoFornecedor()
        println(fornecedor!!.telefones)
    }
}
