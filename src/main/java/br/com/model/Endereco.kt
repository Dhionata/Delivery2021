package br.com.model

import br.com.model.usuario.Usuario
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
data class Endereco(
    @field:ManyToOne @JoinColumn(name = "id_usuario") @field:JsonIgnore var usuario: Usuario,
    var logradouro: String,
    var cidade: String,
    var bairro: String,
    var complemento: String,
    var cep: String,
    var numero: String? = null,
    var coordenadaX: Float? = 0f,
    private var coordenadaY: Float? = 0f
) {
    @Id
    @GeneratedValue
    var id: Int? = null

    init {
        usuario.enderecos.add(this)
    }

    override fun toString(): String {
        return "-- Endereço--\nID: $id\nBairro: $bairro\nCep: $cep\nCidade: $cidade\nComplemento: $complemento\nCoordenada-X:$coordenadaX\nCoordenaxa-Y:$coordenadaY\nLogradouro: $logradouro\nNumero: $numero\nusuario: ${usuario.nome}"
    }
}
