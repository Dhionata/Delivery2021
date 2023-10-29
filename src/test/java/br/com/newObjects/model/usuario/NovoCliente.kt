package br.com.newObjects.model.usuario

import br.com.model.usuario.Cliente
import br.com.newObjects.model.NovoEndereco.novaListaEndereco
import br.com.newObjects.model.NovoTelefone.novaListaTelefones

object NovoCliente {

    private val usuario = NovoUsuario.novoUsuario()

    fun novoCliente(): Cliente {
        val cliente = Cliente(
            usuario.nome + "Cliente!", usuario.cnpjCpf, usuario.senha, usuario.email
        )
        novaListaTelefones(cliente)
        novaListaEndereco(cliente)
        return cliente
    }
}
