package br.com.model.classes;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.classes.NovoItemPedido;
import br.com.newObjects.model.classes.NovoPedido;

public class NovoItemPedidoTest {
    @Test
    void testNovaListaItensPedido() {
        System.out.println(NovoItemPedido.novaListaItensPedido(NovoPedido.novoPedido()).toString());
    }

    @Test
    void testNovoItemPedido() {
        System.out.println(NovoItemPedido.novoItemPedido().toString());
    }
}
