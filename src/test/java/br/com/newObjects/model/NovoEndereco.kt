package br.com.newObjects.model

import br.com.model.Endereco
import br.com.model.usuario.Usuario

object NovoEndereco {

    fun novaListaEndereco(usuario: Usuario) {
        Endereco(
            usuario, "logradouro", "cidade", "bairro", "complemento", "cep", "numero", 0f, 0f
        )
        Endereco(
            usuario, "logradouro2", "cidade2", "bairro2", "complemento2", "cep2", "numero2", 0f, 0f
        )
    }
}
