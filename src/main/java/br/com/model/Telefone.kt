package br.com.model

import br.com.model.usuario.Usuario
import jakarta.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
data class Telefone(
    @field:ManyToOne @field:JoinColumn(name = "id_usuario") private val usuario: Usuario,
    var numero: String
) {
    init {
        usuario.telefones.add(this)
    }

    @field:Id
    @field:GeneratedValue
    var id: Int? = null
    override fun toString(): String {
        return "-- Telefone --\nID: $id\nNúmero: $numero\nUsuário: ${usuario.nome}"
    }
}
