package br.com.services.classes.usuario

import br.com.encrypt.Criptografia
import br.com.encrypt.Criptografia.verificar
import br.com.model.usuario.Usuario
import br.com.repository.usuario.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
open class UsuarioService(private val usuarioRepository: UsuarioRepository) {

    protected open fun salvar(usuario: Usuario): ResponseEntity<Usuario> {
        println("-- Usuário Requisição -- Salvar --$usuario")
        usuario.senha = Criptografia.argon(usuario.senha)

        println("\n\n-- Usuário a ser Salvo --\n\n$usuario")

        usuarioRepository.save(usuario)

        usuario.senha = ""

        return ResponseEntity.ok(usuario)
    }

    protected open fun procurarTodos(): ResponseEntity<MutableIterable<Usuario>> {
        val todos = usuarioRepository.findAll()
        return ResponseEntity.ok(todos)
    }

    protected open fun remover(usuario: Usuario): ResponseEntity<String> {
        return try {
            validate(usuario)

            usuarioRepository.delete(usuario)
            if (usuarioRepository.existsById(usuario.id!!)) {
                throw Exception("A entidade $usuario não foi excluída!")
            } else {
                ResponseEntity.ok("Remoção feita com sucesso!")
            }
        } catch (e: Exception) {
            ResponseEntity.status(500).body("Erro na remoção:${e.message}")
        }
    }

    protected open fun atualizar(usuario: Usuario): ResponseEntity<Usuario> {
        if (usuario.id == null) {
            throw Exception("\n\nId não pode ser nulo\n\n")
        }
        println("\n\n-- Usuário Requisição -- Atualizar --\n\n$usuario")

        usuario.senha = Criptografia.argon(usuario.senha)

        println("\n\n-- Usuário a ser Atualizado --\n\n$usuario")
        usuarioRepository.save(usuario)

        println("\n\n-- Usuário atualizado! --\n\n")
        usuario.senha = ""

        println("\n\n-- Usuário retornado! --\n\n$usuario")
        return ResponseEntity.ok(usuario)
    }

    protected open fun procurarPorID(id: Int): ResponseEntity<Usuario> {
        println("\n\n-- ProcurarPorID --")
        val usuarioSemSenha = usuarioRepository.findById(id).get()

        usuarioSemSenha.senha = ""

        return ResponseEntity.ok(usuarioSemSenha)
    }

    protected open fun buscar(cnpjCpf: String): ResponseEntity<Usuario> {
        println("\n\n\n-- Usuário para Buscar --\n\n\n$cnpjCpf\n\n\n")
        val a = usuarioRepository.findByCnpjCpf(cnpjCpf)

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

    protected open fun autenticaUsuario(usuario: Usuario): Usuario? {
        return try {
            println("-- Usuário para Autenticar --$usuario\n\n\n")
            val a = usuarioRepository.findByEmail(usuario.email)

            println("Existe um usuário com esse email!$a")
            println("Senha do usuário: ${a.senha}\n\n")

            if (verificar(a, usuario.senha)) {
                println("\n\nAs senhas batem!")
                a.senha = ""
                println("Retirada a senha para não ser transmitida pela rede!$a")
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

    fun validate(usuario: Usuario) {
        if (usuario.nome.isBlank()) {
            throw Exception("\n\nNome não pode ser vazio!")
        }
        if (usuario.email.isBlank()) {
            throw Exception("\n\nEmail não pode ser vazio!")
        }
        if (usuario.cnpjCpf.isBlank()) {
            throw Exception("\n\nCNPJ/CPF não pode ser vazio!")
        }
    }
}
