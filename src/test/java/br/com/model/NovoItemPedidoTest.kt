package br.com.model

import br.com.newObjects.model.NovoItemPedido
import br.com.newObjects.model.NovoPedido
import br.com.newObjects.model.NovoProdutoFornecedor
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
