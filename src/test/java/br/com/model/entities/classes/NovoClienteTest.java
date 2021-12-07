package br.com.model.entities.classes;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.entities.classes.usuario.NovoCliente;

public class NovoClienteTest {
    @Test
    public void novoClienteTeste() {
        var cliente = NovoCliente.novoCliente();
        System.out.println(cliente.toString());
    }
}
