package br.com.newObjects.model

import br.com.model.Avaliacao
import br.com.model.Pedido

object NovaAvaliacao {
    fun novaAvaliacao(pedido: Pedido) {
        Avaliacao(5, pedido, "teste de comentário")
    }
}
