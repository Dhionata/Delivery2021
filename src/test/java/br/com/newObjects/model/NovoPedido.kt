package br.com.newObjects.model

import br.com.model.FormaPagamento.Companion.novaFormaPagamento
import br.com.model.Pedido
import br.com.newObjects.model.usuario.NovoCliente
import java.util.*

object NovoPedido {
    fun novoPedido(): Pedido {
        val pedido = Pedido(
            cliente = NovoCliente.novoCliente(),
            formaPagamento = novaFormaPagamento(Random().nextInt(5) + 1),
            desconto = Random().nextFloat(10f)
        )
        NovoItemPedido.novaListaItensPedido(
            pedido, NovoProdutoFornecedor.novaListaProdutosFornecedor()
        )
        NovaAvaliacao.novaAvaliacao(pedido)
        return pedido
    }

    fun novoPedidoSimples(): Pedido {
        return Pedido(
            cliente = NovoCliente.novoCliente(),
            formaPagamento = novaFormaPagamento(Random().nextInt(5) + 1),
            desconto = Random().nextFloat(100f) + 1
        )
    }
}
