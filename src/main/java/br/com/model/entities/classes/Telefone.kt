package br.com.model.entities.classes

import br.com.model.entities.classes.usuario.Usuario
import jakarta.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
data class Telefone(
    @field:ManyToOne @field:JoinColumn(name = "id_usuario") private val usuario: Usuario,
    var numero: String
) {
    @field:Id
    @field:GeneratedValue
    var id: Int? = null
    override fun toString(): String {
        return "-- Telefone --\nID: $id\nNúmero: $numero\nUsuário: ${usuario.nome}"
    }
}
