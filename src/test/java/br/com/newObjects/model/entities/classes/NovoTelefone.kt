package br.com.newObjects.model.entities.classes

import br.com.model.entities.classes.Telefone
import br.com.model.entities.classes.usuario.Usuario

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
