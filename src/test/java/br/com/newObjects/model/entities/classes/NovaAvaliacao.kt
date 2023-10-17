package br.com.newObjects.model.entities.classes

import br.com.model.entities.classes.Avaliacao
import br.com.model.entities.classes.Pedido

object NovaAvaliacao {
    fun novaAvaliacao(pedido: Pedido) {
        Avaliacao(5, pedido, "teste de comentário")
    }
}
