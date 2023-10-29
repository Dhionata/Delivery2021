package br.com.encrypt

import br.com.controllers.usuario.ClienteController
import br.com.encrypt.Criptografia.verificar
import br.com.newObjects.model.usuario.NovoCliente
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TesteCriptografiaCliente(@Autowired private val clienteController: ClienteController) {

    @Test
    @Throws(Exception::class)
    fun save() {
        val cliente = clienteController.salvar(NovoCliente.novoCliente())
        Assertions.assertTrue(verificar(cliente!!.body, "teste123456"))
    }
}
