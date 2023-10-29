package br.com.model.usuario

import br.com.encrypt.Criptografia
import br.com.model.Endereco
import br.com.model.Pedido
import br.com.model.Telefone
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.validator.constraints.br.CNPJ
import org.hibernate.validator.constraints.br.CPF
import java.util.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
open class Usuario(
    open var nome: String,
    @field:Column(unique = true) @field:CPF @field:CNPJ open var cnpjCpf: String,
    senha: String,
    open var email: String,
    open var data: Date = Date(),
    @field:Enumerated open var tipo: TipoUsuario = TipoUsuario.CLIENTE,
    @field:OneToMany(cascade = [CascadeType.ALL]) @field:JsonIgnore open var enderecos: MutableList<Endereco> = ArrayList(),
    @field:OneToMany(cascade = [CascadeType.ALL]) @field:JsonIgnore open var telefones: MutableList<Telefone> = ArrayList(),
    @field:OneToMany(cascade = [CascadeType.ALL]) @field:JsonIgnore open var pedidos: MutableList<Pedido> = ArrayList(),
) {
    @field:Id
    @field:GeneratedValue
    open var id: Int? = null
    open var senha = Criptografia.argon(senha)

    override fun toString(): String {
        return "--usuario--ID: $id Nome: $nome Email: $email CNPJCPF: $cnpjCpf Data: $data Tipo de usuário: ${
            tipo.name
        }Senha: $senha"
    }
}
