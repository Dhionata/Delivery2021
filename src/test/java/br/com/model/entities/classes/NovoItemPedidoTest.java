package br.com.model.entities.classes;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.entities.classes.NovoItemPedido;
import br.com.newObjects.model.entities.classes.NovoPedido;
import br.com.newObjects.model.entities.classes.NovoProdutoFornecedor;

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
