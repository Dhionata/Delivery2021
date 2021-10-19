package br.com.encrypt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.controllers.Usuario.ClienteController;
import br.com.newObjects.model.classes.NovoCliente;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TesteCriptografiaCliente {

    @Autowired
    private ClienteController clienteController;

    @Test
    void save() throws Exception {
        var cliente = clienteController.save(NovoCliente.novoCliente());
        assertTrue(Criptografia.verificar(cliente, "teste123456"));
    }
}
