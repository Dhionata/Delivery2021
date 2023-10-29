package br.com.services.classes.usuario

import br.com.encrypt.Criptografia
import br.com.encrypt.Criptografia.verificar
import br.com.model.usuario.Cliente
import br.com.repository.usuario.ClienteRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam

@Service
open class ClienteService(private val clienteRepository: ClienteRepository) {

    open fun salvar(@RequestParam cliente: Cliente): ResponseEntity<Cliente> {
        val a = clienteRepository.save(cliente)
        return ResponseEntity.ok(a)
    }

    open fun procurarTodos(): ResponseEntity<Iterable<Cliente>> {
        val all = clienteRepository.findAll()
        for (c in all) {
            c.senha = ""
        }
        return ResponseEntity.ok(all)
    }

    open fun remover(@RequestParam cliente: Cliente): ResponseEntity<String> {
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

    open fun atualizar(@RequestParam cliente: Cliente): ResponseEntity<Cliente> {
        if (cliente.id == null) {
            throw Exception("\n\nId não pode ser nulo\n\n")
        }
        println("\n\n-- Usuário Requisição -- Atualizar --\n\n$cliente")
        return run {
            println("\n\nUsuário tem senha!!!")
            cliente.senha = Criptografia.argon(cliente.senha)
            println("\n\n-- Usuário a ser Atualizado --\n\n$cliente")
            clienteRepository.save(cliente)
            println("\n\n-- Usuário atualizado! --\n\n")
            cliente.senha = ""
            println("\n\n-- Usuário retornado! --\n\n$cliente")
            ResponseEntity.ok(cliente)
        }
    }

    open fun procurarPorID(@RequestParam id: Int): ResponseEntity<Cliente> {
        println("\n\n-- ProcurarPorID --")
        val clienteSemSenha = clienteRepository.findById(id).get()
        clienteSemSenha.senha = ""
        return ResponseEntity.ok(clienteSemSenha)
    }

    fun buscarPorCnpjCpf(@RequestParam cnpjCpf: String): ResponseEntity<Cliente> {
        println("\n\n\n-- Usuário para Buscar --\n\n\n$cnpjCpf\n\n\n")
        val a = clienteRepository.findByCnpjCpf(cnpjCpf)
        return run {
            println("\n\nAchou algo no banco de dados!")
            if (a.cnpjCpf == cnpjCpf) {
                println("\n\nEra igual!")
                a.senha = ""
                ResponseEntity.ok(a)
            } else {
                println("\n\nNÃO Era igual!")
                ResponseEntity.notFound().build()
            }
        }
    }

    protected fun autenticaCliente(@RequestParam cliente: Cliente): Cliente? {
        return try {
            println("\n\n\n-- Usuário para Autenticar --\n\n\n$cliente\n\n\n")
            val a = clienteRepository.findByEmail(cliente.email)
            println("Existe um usuário com esse email!$a")
            println("Senha do usuário: ${a.senha}")
            if (verificar(a, cliente.senha)) {
                println("\n\nAs senhas batem!")
                a.senha = ""
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
