package br.com.model.entities.classes;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.entities.classes.NovoItemPedido;
import br.com.newObjects.model.entities.classes.NovoPedido;
import br.com.newObjects.model.entities.classes.NovoProdutoFornecedor;

public class NovoItemPedidoTest {
    @Test
    void testNovaListaItensPedido() {
        var a = NovoPedido.novoPedido();
        NovoItemPedido.novaListaItensPedido(a, NovoProdutoFornecedor.novaListaProdutosFornecedor());
        System.out.println(a.getItensPedido());
    }

    @Test
    void testNovoItemPedido() {
        var a = NovoPedido.novoPedido();
        NovoItemPedido.novoItemPedido(a);
        System.out.println(a.getItensPedido());
    }
}
