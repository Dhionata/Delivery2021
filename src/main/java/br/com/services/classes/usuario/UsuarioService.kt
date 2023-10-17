package br.com.services.classes.usuario

import br.com.encrypt.Criptografia.verificar
import br.com.model.entities.classes.usuario.Usuario
import br.com.repository.usuario.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam

@Service
open class UsuarioService(@Autowired private val usuarioRepository: UsuarioRepository) {

    @Throws(Exception::class)
    protected open fun salvar(@RequestParam usuario: Usuario): ResponseEntity<Usuario> {
        println("-- Usuário Requisição -- Salvar --$usuario")
        val usuarioTemp = Usuario(usuario)

        println("\n\n-- Usuário a ser Salvo --\n\n$usuarioTemp")

        usuarioRepository.save(usuarioTemp)

        usuarioTemp.senha = null

        return ResponseEntity.ok(usuarioTemp)
    }

    protected open fun procurarTodos(): ResponseEntity<MutableIterable<Usuario>> {
        val todos = usuarioRepository.findAll()
        return ResponseEntity.ok(todos)
    }

    @Throws(Exception::class)
    protected open fun remover(@RequestParam usuario: Usuario): ResponseEntity<String> {
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

    @Throws(Exception::class)
    protected open fun atualizar(@RequestParam usuario: Usuario): ResponseEntity<Usuario> {
        if (usuario.id == null) {
            throw Exception("\n\nId não pode ser nulo\n\n")
        }
        println("\n\n-- Usuário Requisição -- Atualizar --\n\n$usuario")
        val usuarioOldTemp = if (usuario.senha != null) Usuario(usuario) else usuario

        println("\n\n-- Usuário a ser Atualizado --\n\n$usuarioOldTemp")
        usuarioRepository.save(usuarioOldTemp)

        println("\n\n-- Usuário atualizado! --\n\n")
        usuarioOldTemp.senha = null

        println("\n\n-- Usuário retornado! --\n\n$usuarioOldTemp")
        return ResponseEntity.ok(usuarioOldTemp)
    }

    protected open fun procurarPorID(@RequestParam id: Int): ResponseEntity<Usuario> {
        println("\n\n-- ProcurarPorID --")
        val usuarioSemSenha = usuarioRepository.findById(id).get()

        usuarioSemSenha.senha = null

        return ResponseEntity.ok(usuarioSemSenha)
    }

    protected open fun buscar(@RequestParam cnpjCpf: String): ResponseEntity<Usuario> {
        println("\n\n\n-- Usuário para Buscar --\n\n\n$cnpjCpf\n\n\n")
        val a = usuarioRepository.findByCnpjCpf(cnpjCpf)

        return run {
            println("\n\nAchou algo no banco de dados!")
            if (a.cnpjCpf == cnpjCpf) {
                println("\n\nEra igual!")
                a.senha = null
                ResponseEntity.ok(a)
            } else {
                println("\n\nNÃO Era igual!")
                ResponseEntity.notFound().build()
            }
        }
    }

    protected open fun autenticaUsuario(@RequestParam usuario: Usuario): Usuario? {
        return try {
            println("-- Usuário para Autenticar --$usuario\n\n\n")
            val a = usuarioRepository.findByEmail(usuario.email)

            println("Existe um usuário com esse email!$a")
            println("Senha do usuário: ${a.senha}\n\n")

            if (verificar(a, usuario.senha!!)) {
                println("\n\nAs senhas batem!")
                a.senha = null
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

    @Throws(Exception::class)
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
