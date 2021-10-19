package br.com.model.classes;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.classes.NovoPedido;

public class NovoPedidoTest {
    @Test
    void testNovoPedido() {
        System.out.println(NovoPedido.novoPedido().toString());
    }
}
