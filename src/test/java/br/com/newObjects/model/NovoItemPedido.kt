package br.com.newObjects.model

import br.com.model.ItemPedido
import br.com.model.Pedido
import br.com.model.ProdutoFornecedor
import java.util.*

object NovoItemPedido {
    fun novaListaItensPedido(pedido: Pedido, produtoFornecedores: List<ProdutoFornecedor>) {
        ItemPedido(
            pedido = pedido, produto = produtoFornecedores[0].produto, quantidade = Random().nextInt(10) + 1
        )
        ItemPedido(
            pedido = pedido, produto = produtoFornecedores[1].produto, quantidade = Random().nextInt(10) + 1
        )
    }

    fun novoItemPedido(pedido: Pedido) {
        ItemPedido(pedido = pedido, produto = NovoProduto.novoProduto(), quantidade = Random().nextInt(10))
    }
}
