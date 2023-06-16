package br.com.encrypt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.controllers.usuario.ClienteController;
import br.com.newObjects.model.entities.classes.usuario.NovoCliente;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TesteCriptografiaCliente {

    @Autowired
    private ClienteController clienteController;

    @Test
    void save() throws Exception {
        var cliente = clienteController.salvar(NovoCliente.novoCliente());
        assertTrue(Criptografia.verificar(cliente.getBody(), "teste123456"));
    }
}
