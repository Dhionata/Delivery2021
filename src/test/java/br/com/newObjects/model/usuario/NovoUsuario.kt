package br.com.newObjects.model.usuario

import br.com.model.usuario.Usuario
import kotlin.random.Random

object NovoUsuario {

    fun novoUsuario() = Usuario(
        "NomeUsuarioTeste",
        cpf(),
        "teste${Random.nextInt(99999)}",
        "teste@gmailCliente.com"
    )

    private fun cpf() = List(3) { "%03d".format(Random.nextInt(999)) }.joinToString(".") +
            "-%02d".format(Random.nextInt(99))
}
