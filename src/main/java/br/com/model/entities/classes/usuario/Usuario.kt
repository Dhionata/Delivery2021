package br.com.model.entities.classes.usuario

import br.com.encrypt.Criptografia
import br.com.model.entities.classes.Endereco
import br.com.model.entities.classes.Pedido
import br.com.model.entities.classes.Telefone
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
open class Usuario(
    var nome: String,
    @field:Column(unique = true) var cnpjCpf: String,
    senha: String,
    var email: String,
    var data: Date = Date(),
    @field:Enumerated var tipo: TipoUsuario = TipoUsuario.CLIENTE,
    @field:OneToMany(cascade = [CascadeType.ALL]) @field:JsonIgnore var enderecos: MutableList<Endereco> = ArrayList(),
    @field:OneToMany(cascade = [CascadeType.ALL]) @field:JsonIgnore var telefones: MutableList<Telefone> = ArrayList(),
    @field:OneToMany(cascade = [CascadeType.ALL]) @field:JsonIgnore var pedidos: MutableList<Pedido> = ArrayList(),
) {
    @field:Id
    @field:GeneratedValue
    var id: Int? = null
    var senha = Criptografia.argon(senha)

    constructor(usuario: Usuario) : this(
        usuario.nome,
        usuario.cnpjCpf,
        usuario.senha!!,
        usuario.email,
        usuario.data,
        usuario.tipo,
        usuario.enderecos,
        usuario.telefones,
        usuario.pedidos
    )

    override fun toString(): String {
        return "--usuario--ID: $id Nome: $nome Email: $email CNPJCPF: $cnpjCpf Data: $data Tipo de usuário: ${
            tipo.name
        }Senha: $senha"
    }
}
