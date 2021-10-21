package br.com.model.classes;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.classes.NovoItemPedido;
import br.com.newObjects.model.classes.NovoPedido;
import br.com.newObjects.model.classes.NovoProdutoFornecedor;

public class NovoItemPedidoTest {
    @Test
    void testNovaListaItensPedido() {
        System.out.println(NovoItemPedido.novaListaItensPedido(NovoPedido.novoPedidoSimples(),
                NovoProdutoFornecedor.novaListaProdutosFornecedor()));
    }

    @Test
    void testNovoItemPedido() {
        System.out.println(NovoItemPedido.novoItemPedido(NovoPedido.novoPedidoSimples()));
    }
}
