package br.com.services.classes.usuario

import br.com.encrypt.Criptografia
import br.com.encrypt.Criptografia.verificar
import br.com.model.usuario.Fornecedor
import br.com.repository.usuario.FornecedorRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam

@Service
open class FornecedorService(private val fornecedorRepository: FornecedorRepository) {

    @Throws(Exception::class)
    open fun salvar(@RequestParam fornecedor: Fornecedor): ResponseEntity<Fornecedor> {
        println("\n\n-- Usuário Requisição -- Salvar --\n\n$fornecedor")
        fornecedor.senha = Criptografia.argon(fornecedor.senha)
        println("\n\n-- Usuário a ser Salvo --\n\n$fornecedor")
        fornecedorRepository.save(fornecedor)
        fornecedor.senha = ""
        return ResponseEntity.ok(fornecedor)
    }

    open fun procurarTodos(): ResponseEntity<MutableIterable<Fornecedor>> {
        val todos = fornecedorRepository.findAll()
        return ResponseEntity.ok(todos)
    }

    @Throws(Exception::class)
    open fun remover(@RequestParam fornecedor: Fornecedor): ResponseEntity<String> {
        return try {
            validate(fornecedor)
            fornecedorRepository.delete(fornecedor)
            if (fornecedorRepository.existsById(fornecedor.id!!)) {
                throw Exception("A entidade $fornecedor não foi excluída!")
            } else {
                ResponseEntity.ok("Remoção feita com sucesso!")
            }
        } catch (e: Exception) {
            ResponseEntity.status(500).body(" Erro na remoção:${e.message}")
        }
    }

    @Throws(Exception::class)
    open fun atualizar(@RequestParam fornecedor: Fornecedor): ResponseEntity<Fornecedor> {
        if (fornecedor.id == null) {
            throw Exception("\n\nId não pode ser nulo\n\n")
        }
        println("\n\n-- Usuário Requisição -- Atualizar --\n\n$fornecedor")
        fornecedor.senha = Criptografia.argon(fornecedor.senha)
        println("\n\n-- Usuário a ser Atualizado --\n\n$fornecedor")
        fornecedorRepository.save(fornecedor)
        println("\n\n-- Usuário atualizado! --\n\n")
        fornecedor.senha = ""
        println("\n\n-- Usuário retornado! --\n\n$fornecedor")
        return ResponseEntity.ok(fornecedor)
    }

    open fun procurarPorID(@RequestParam id: Int): ResponseEntity<Fornecedor>? {
        println("\n\n-- ProcurarPorID --")
        val fornecedor = fornecedorRepository.findById(id).get()
        fornecedor.senha = ""
        return ResponseEntity.ok(fornecedor)
    }

    fun buscar(@RequestParam cnpjCpf: String): ResponseEntity<Fornecedor> {
        println("\n\n\n-- Usuário para Buscar --\n\n\n$cnpjCpf\n\n\n")
        val fornecedor = fornecedorRepository.findByCnpjCpf(cnpjCpf)
        return run {
            println("\n\nAchou algo no banco de dados!")
            if (fornecedor.cnpjCpf == cnpjCpf) {
                println("\n\nEra igual!")
                fornecedor.senha = ""
                ResponseEntity.ok(fornecedor)
            } else {
                println("\n\nNÃO Era igual!")
                ResponseEntity.notFound().build()
            }
        }
    }

    protected fun autenticaFornecedor(@RequestParam fornecedor: Fornecedor): Fornecedor? {
        return try {
            println("\n\n\n-- Usuário para Autenticar --\n\n\n$fornecedor\n\n\n")
            val fornecedorBanco = fornecedorRepository.findByEmail(fornecedor.email)
            println("Existe um usuário com esse email!$fornecedorBanco")
            println("Senha do usuário: ${fornecedorBanco.senha}")
            if (verificar(fornecedorBanco, fornecedorBanco.senha)) {
                println("\n\nAs senhas batem!")
                fornecedorBanco.senha = ""
                println(
                    "\n\nRetirada a senha para não ser transmitida pela rede!$fornecedorBanco"
                )
                fornecedorBanco
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
    open fun validate(fornecedor: Fornecedor) {
        if (fornecedor.nome.isBlank()) {
            throw Exception("\n\nNome não pode ser vazio!")
        }
        if (fornecedor.email.isBlank()) {
            throw Exception("\n\nEmail não pode ser vazio!")
        }
        if (fornecedor.cnpjCpf.isBlank()) {
            throw Exception("\n\nCNPJ/CPF não pode ser vazio!")
        }
    }
}
