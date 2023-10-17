package br.com.newObjects.model.entities.classes.usuario

import br.com.model.entities.classes.usuario.Fornecedor
import br.com.model.entities.classes.usuario.Usuario
import br.com.newObjects.model.entities.classes.NovoEndereco.novaListaEndereco
import br.com.newObjects.model.entities.classes.NovoTelefone.novaListaTelefones

object NovoFornecedor {

    val usuario = Usuario(
        "TesteLTDA",
        "000.000.000-00",
        "senhaTeste",
        "email@testeFornecedor.com.br"
    )

    fun novoFornecedor(): Fornecedor {
        val fornecedor = Fornecedor(
            usuario,
        )
        novaListaEndereco(fornecedor)
        novaListaTelefones(fornecedor)
        return fornecedor
    }
}
