package br.com.model.usuario

import br.com.model.Endereco
import br.com.model.Pedido
import br.com.model.Telefone
import jakarta.persistence.Entity
import java.util.*

@Entity
data class Cliente(
    override var nome: String,
    override var cnpjCpf: String,
    override var senha: String,
    override var email: String,
    override var data: Date = Date(),
    override var tipo: TipoUsuario = TipoUsuario.FORNECEDOR,
    override var enderecos: MutableList<Endereco> = ArrayList(),
    override var telefones: MutableList<Telefone> = ArrayList(),
    override var pedidos: MutableList<Pedido> = ArrayList(),
) : Usuario(nome, cnpjCpf, senha, email, data, tipo, enderecos, telefones, pedidos) {

    override fun toString(): String {
        return "\n--Cliente--\nID: ${super.id}\nNome: ${super.nome}\nCNPJ/CPF: ${super.cnpjCpf}\nData:${
            super.data
        }\nEmail: ${super.email}\nSenha: ${super.senha}\n-- Lista de telefones --${super.telefones}\n-- Lista de " +
                "endereços-- ${super.enderecos}\nTipo de Usuário: ${super.tipo}"
    }
}
