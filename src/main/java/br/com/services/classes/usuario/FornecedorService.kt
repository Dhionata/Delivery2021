package br.com.services.classes.usuario

import br.com.encrypt.Criptografia.verificar
import br.com.model.entities.classes.usuario.Fornecedor
import br.com.repository.usuario.FornecedorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam

@Service
open class FornecedorService(@Autowired private val fornecedorRepository: FornecedorRepository) {

    @Throws(Exception::class)
    open fun salvar(@RequestParam fornecedor: Fornecedor): ResponseEntity<Fornecedor> {
        println("\n\n-- Usuário Requisição -- Salvar --\n\n$fornecedor")
        val fornecedorTemp = Fornecedor(fornecedor)
        println("\n\n-- Usuário a ser Salvo --\n\n$fornecedorTemp")
        fornecedorRepository.save(fornecedorTemp)
        fornecedorTemp.senha = null
        return ResponseEntity.ok(fornecedorTemp)
    }

    open fun procurarTodos(): ResponseEntity<MutableIterable<Fornecedor>> {
        val todos = fornecedorRepository.findAll()
        return ResponseEntity.ok(todos)
    }

    @Throws(Exception::class)
    open fun remover(@RequestParam fornecedor: Fornecedor): ResponseEntity<String>? {
        return try {
            validate(fornecedor)
            fornecedorRepository.delete(fornecedor)
            if (fornecedorRepository.existsById(fornecedor.id!!)) {
                throw Exception("A entidade $fornecedor não foi excluída!")
            } else {
                ResponseEntity.ok("Remoção feita com sucesso!")
            }
        } catch (e: Exception) {
            ResponseEntity.status(500).body(
                """
    Erro na remoção:
    ${e.message}
    """.trimIndent()
            )
        }
    }

    @Throws(Exception::class)
    open fun atualizar(@RequestParam fornecedor: Fornecedor): ResponseEntity<Fornecedor>? {
        if (fornecedor.id == null) {
            throw Exception("\n\nId não pode ser nulo\n\n")
        }
        println("\n\n-- Usuário Requisição -- Atualizar --\n\n$fornecedor")
        val FornecedorTemp = if (fornecedor.senha != null) Fornecedor(fornecedor) else fornecedor
        println("\n\n-- Usuário a ser Atualizado --\n\n$FornecedorTemp")
        fornecedorRepository.save(FornecedorTemp)
        println("\n\n-- Usuário atualizado! --\n\n")
        FornecedorTemp.senha = null
        println("\n\n-- Usuário retornado! --\n\n$FornecedorTemp")
        return ResponseEntity.ok(FornecedorTemp)
    }

    open fun procurarPorID(@RequestParam id: Int): ResponseEntity<Fornecedor>? {
        println("\n\n-- ProcurarPorID --")
        val fornecedor = fornecedorRepository.findById(id).get()
        fornecedor.senha = null
        return ResponseEntity.ok(fornecedor)
    }

    fun buscar(@RequestParam cnpjCpf: String): ResponseEntity<Fornecedor> {
        println("\n\n\n-- Usuário para Buscar --\n\n\n$cnpjCpf\n\n\n")
        val fornecedorTemp = fornecedorRepository.findByCnpjCpf(cnpjCpf)
        return run {
            println("\n\nAchou algo no banco de dados!")
            if (fornecedorTemp.cnpjCpf == cnpjCpf) {
                println("\n\nEra igual!")
                fornecedorTemp.senha = null
                ResponseEntity.ok(fornecedorTemp)
            } else {
                println("\n\nNÃO Era igual!")
                ResponseEntity.notFound().build()
            }
        }
    }

    protected fun autenticaFornecedor(@RequestParam fornecedor: Fornecedor): Fornecedor? {
        return try {
            println("\n\n\n-- Usuário para Autenticar --\n\n\n$fornecedor\n\n\n")
            val fornecedorTemp = fornecedorRepository.findByEmail(fornecedor.email)
            println(
                """
    
    
    Existe um usuário com esse email!
    
    ${fornecedorTemp.toString()}
    """.trimIndent()
            )
            println(
                """
    
    
    Senha do usuário: ${fornecedorTemp!!.senha}
    
    
    """.trimIndent()
            )
            if (verificar(fornecedorTemp, fornecedor.senha!!)) {
                println("\n\nAs senhas batem!")
                fornecedorTemp.senha = null
                println(
                    "\n\nRetirada a senha para não ser transmitida pela rede!$fornecedorTemp"
                )
                fornecedorTemp
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
