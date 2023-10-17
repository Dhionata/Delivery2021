package br.com.services.classes.usuario

import br.com.encrypt.Criptografia.verificar
import br.com.model.entities.classes.usuario.Cliente
import br.com.repository.usuario.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam

@Service
open class ClienteService(@Autowired private val clienteRepository: ClienteRepository) {

    @Throws(Exception::class)
    open fun salvar(@RequestParam cliente: Cliente): ResponseEntity<Cliente>? {
        val a = clienteRepository.save(cliente)
        return ResponseEntity.ok(a)
    }

    open fun procurarTodos(): ResponseEntity<Iterable<Cliente?>>? {
        val todo = clienteRepository.findAll()
        for (c in todo) {
            c!!.senha = null
        }
        return ResponseEntity.ok(todo)
    }

    @Throws(Exception::class)
    open fun remover(@RequestParam cliente: Cliente): ResponseEntity<String>? {
        return try {
            validate(cliente)
            clienteRepository.delete(cliente)

            if (clienteRepository.findAll().any { cliente1 -> cliente1 == cliente }) {
                throw Exception("A entidade $cliente não foi excluída!")
            } else {
                ResponseEntity.ok("Remoção feita com sucesso!")
            }
        } catch (e: Exception) {
            ResponseEntity.status(500).body("Erro na remoção:${e.message}")
        }
    }

    @Throws(Exception::class)
    open fun atualizar(@RequestParam cliente: Cliente): ResponseEntity<Cliente>? {
        if (cliente.id == null) {
            throw Exception("\n\nId não pode ser nulo\n\n")
        }
        println("\n\n-- Usuário Requisição -- Atualizar --\n\n$cliente")
        return if (cliente.senha != null) {
            println("\n\nUsuário tem senha!!!")
            val clienteTemp = Cliente(cliente)
            println("\n\n-- Usuário a ser Atualizado --\n\n$clienteTemp")
            clienteRepository.save(clienteTemp)
            println("\n\n-- Usuário atualizado! --\n\n")
            clienteTemp.senha = null
            println("\n\n-- Usuário retornado! --\n\n$clienteTemp")
            ResponseEntity.ok(cliente)
        } else {
            println("\n\nUsuário não tem senha!!!")
            println("\n\n-- Usuário a ser Atualizado --\n\n$cliente")
            clienteRepository.save(cliente)
            println("\n\n-- Usuário atualizado! --\n\n")
            cliente.senha = null
            println("\n\n-- Usuário retornado! --\n\n$cliente")
            ResponseEntity.ok(cliente)
        }
    }

    open fun procurarPorID(@RequestParam id: Int): ResponseEntity<Cliente>? {
        println("\n\n-- ProcurarPorID --")
        val clienteSemSenha = clienteRepository.findById(id).get()
        clienteSemSenha.senha = null
        return ResponseEntity.ok(clienteSemSenha)
    }

    fun buscarPorCnpjCpf(@RequestParam cnpjCpf: String): ResponseEntity<Cliente> {
        println("\n\n\n-- Usuário para Buscar --\n\n\n$cnpjCpf\n\n\n")
        val a = clienteRepository.findByCnpjCpf(cnpjCpf)
        return if (a != null) {
            println("\n\nAchou algo no banco de dados!")
            if (a.cnpjCpf == cnpjCpf) {
                println("\n\nEra igual!")
                a.senha = null
                ResponseEntity.ok(a)
            } else {
                println("\n\nNÃO Era igual!")
                ResponseEntity.notFound().build()
            }
        } else {
            println("NÃO achou nada no banco!")
            ResponseEntity.notFound().build()
        }
    }

    protected fun autenticaCliente(@RequestParam cliente: Cliente): Cliente? {
        return try {
            println("\n\n\n-- Usuário para Autenticar --\n\n\n$cliente\n\n\n")
            val a = clienteRepository.findByEmail(cliente.email)
            println("Existe um usuário com esse email!${a.toString()}")
            println("Senha do usuário: ${a!!.senha}")
            if (verificar(a, cliente.senha!!)) {
                println("\n\nAs senhas batem!")
                a.senha = null
                println("\n\nRetirada a senha para não ser transmitida pela rede!$a")
                a
            } else {
                println("\n\nAs senhas não batem!\n\n")
                null
            }
        } catch (ex: Exception) {
            println("Deu ruim...${ex.message}")
            null
        }
    }

    @Throws(Exception::class)
    open fun validate(cliente: Cliente) {
        if (cliente.nome.isBlank()) {
            throw Exception("\n\nNome não pode ser vazio!")
        }
        if (cliente.email.isBlank()) {
            throw Exception("\n\nEmail não pode ser vazio!")
        }
        if (cliente.cnpjCpf.isBlank()) {
            throw Exception("\n\nCNPJ/CPF não pode ser vazio!")
        }
    }
}
