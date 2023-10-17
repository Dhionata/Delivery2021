package br.com.newObjects.model.entities.classes.usuario

import br.com.model.entities.classes.usuario.Cliente
import br.com.model.entities.classes.usuario.Usuario
import br.com.newObjects.model.entities.classes.NovoEndereco.novaListaEndereco
import br.com.newObjects.model.entities.classes.NovoTelefone.novaListaTelefones

object NovoCliente {

    val usuario = Usuario(
        "NomeClienteTeste",
        "000.000.000-00",
        "teste123456",
        "teste@gmailCliente.com"
    )


    fun novoCliente(): Cliente {
        val cliente = Cliente(
            usuario
        )
        novaListaTelefones(cliente)
        novaListaEndereco(cliente)
        return cliente
    }
}
