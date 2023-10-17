package br.com.model.entities.classes

import br.com.newObjects.model.entities.classes.NovoItemPedido
import br.com.newObjects.model.entities.classes.NovoPedido
import br.com.newObjects.model.entities.classes.NovoProdutoFornecedor
import org.junit.jupiter.api.Test

class NovoItemPedidoTest {
    @Test
    fun testNovaListaItensPedido() {
        val a = NovoPedido.novoPedido()
        NovoItemPedido.novaListaItensPedido(a, NovoProdutoFornecedor.novaListaProdutosFornecedor())
        println(a!!.itensPedido)
    }

    @Test
    fun testNovoItemPedido() {
        val a = NovoPedido.novoPedido()
        NovoItemPedido.novoItemPedido(a)
        println(a!!.itensPedido)
    }
}
