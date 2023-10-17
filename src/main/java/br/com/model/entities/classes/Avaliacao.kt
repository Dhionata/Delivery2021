package br.com.model.entities.classes

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class Avaliacao(
    var nota: Int,

    @field:OneToOne @field:JoinColumn(name = "id_pedido") @field:JsonIgnore var pedido: Pedido,
    private var comentario: String? = null,
) {

    @field:Id
    @field:GeneratedValue
    var id: Int? = null
    override fun toString(): String {
        return "-- Avaliacao --ID: ${id}\nComentário: ${comentario}\nNota: ${nota}\nID do Pedido: ${pedido.id}"
    }
}
