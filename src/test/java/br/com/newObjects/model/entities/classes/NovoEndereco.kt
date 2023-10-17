package br.com.newObjects.model.entities.classes

import br.com.model.entities.classes.Endereco
import br.com.model.entities.classes.usuario.Usuario

object NovoEndereco {
    @JvmStatic
    fun novaListaEndereco(usuario: Usuario) {
        Endereco(
            usuario, "logradouro", "cidade", "bairro", "complemento", "cep", "numero", 0f, 0f
        )
        Endereco(
            usuario, "logradouro2", "cidade2", "bairro2", "complemento2", "cep2", "numero2", 0f, 0f
        )
    }
}
