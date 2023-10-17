package br.com.encrypt

import br.com.encrypt.Criptografia.verificar
import br.com.newObjects.model.entities.classes.usuario.NovoCliente
import org.junit.jupiter.api.Test

class CriptografiaTest {
    @Test
    fun argon2() {
        verificar(NovoCliente.novoCliente(), "teste123456")
    }
}
