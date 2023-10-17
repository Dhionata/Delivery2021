package br.com.model.entities.classes

import jakarta.persistence.*

@Entity
data class ItemPedido(
    @field:ManyToOne
    @field:JoinColumn(name = "id_pedido") var pedido: Pedido,

    @field:ManyToOne(cascade = [CascadeType.ALL]) @field:JoinColumn(name = "id_produto") var produto: Produto,
    var quantidade: Int
) {
    @field:Id
    @field:GeneratedValue
    var id: Int? = null
    override fun toString(): String {
        return "-- ItemPedido --ID: $id\nPedido: ${pedido.id}\n$produto\nQuantidade pedida: $quantidade"
    }
}
