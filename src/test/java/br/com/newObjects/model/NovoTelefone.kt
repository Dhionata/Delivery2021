package br.com.newObjects.model

import br.com.model.Telefone
import br.com.model.usuario.Usuario

object NovoTelefone {
    @JvmStatic
    fun novaListaTelefones(usuario: Usuario) {
        Telefone(usuario, "(ii)thhhh-hhhh")
        Telefone(usuario, "(yy)qaaaa-zzzz")
    }

    @JvmStatic
    fun novoTelefone(usuario: Usuario) {
        Telefone(usuario, "(xx)yyyy-yyyy")
    }
}
