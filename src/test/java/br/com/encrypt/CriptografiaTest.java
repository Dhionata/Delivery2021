package br.com.encrypt;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.entities.classes.usuario.NovoCliente;

public class CriptografiaTest {

    @Test
    void argon2() {
        Criptografia.verificar(NovoCliente.novoCliente(), "teste123456");
    }
}
