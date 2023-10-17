package br.com.model.entities.classes.usuario

import jakarta.persistence.Entity
import jakarta.persistence.PrimaryKeyJoinColumn

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
data class Cliente(
    val usuario: Usuario
) : Usuario(
    usuario
) {

    override fun toString(): String {
        return "\n--Cliente--\nID: ${super.id}\nNome: ${super.nome}\nCNPJ/CPF: ${super.cnpjCpf}\nData:${
            super.data
        }\nEmail: ${super.email}\nSenha: ${super.senha}\n-- Lista de telefones --${super.telefones}\n-- Lista de Endereços-- ${super.enderecos}\nTipo de Usuário: ${super.tipo}"
    }
}
