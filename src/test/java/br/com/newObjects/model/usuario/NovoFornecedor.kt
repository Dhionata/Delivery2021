package br.com.newObjects.model.usuario

import br.com.model.usuario.Fornecedor
import br.com.newObjects.model.NovoEndereco.novaListaEndereco
import br.com.newObjects.model.NovoTelefone.novaListaTelefones

object NovoFornecedor {

    private val usuario = NovoUsuario.novoUsuario()

    fun novoFornecedor(): Fornecedor {
        val fornecedor = Fornecedor(
            usuario.nome, usuario.cnpjCpf, usuario.senha, usuario.email
        )
        novaListaEndereco(fornecedor)
        novaListaTelefones(fornecedor)
        return fornecedor
    }
}
