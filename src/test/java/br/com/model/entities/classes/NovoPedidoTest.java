package br.com.model.entities.classes;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.entities.classes.NovoPedido;

public class NovoPedidoTest {
    @Test
    void testNovoPedido() {
        System.out.println(NovoPedido.novoPedido().toString());
    }
}
