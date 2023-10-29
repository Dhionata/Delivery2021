package br.com.controllers.usuario

import br.com.repository.usuario.UsuarioRepository
import br.com.services.classes.usuario.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import br.com.model.usuario.Usuario

@RestController
@CrossOrigin(origins = ["*"])
class UsuarioController(@Autowired private val usuarioRepository: UsuarioRepository) : UsuarioService
    (usuarioRepository) {

    companion object {
        const val URL = "/usuario"
    }

    @GetMapping("$URL/all")
    override fun procurarTodos(): ResponseEntity<MutableIterable<Usuario>> {
        return super.procurarTodos()
    }

    @PostMapping(URL)
    @Throws(Exception::class)
    override fun salvar(@RequestBody usuario: Usuario): ResponseEntity<Usuario> {
        return super.salvar(usuario)
    }

    @DeleteMapping(URL)
    @Throws(Exception::class)
    override fun remover(@RequestBody usuario: Usuario): ResponseEntity<String> {
        return super.remover(usuario)
    }

    @PatchMapping(URL)
    @Throws(Exception::class)
    override fun atualizar(@RequestBody usuario: Usuario): ResponseEntity<Usuario> {
        return super.atualizar(usuario)
    }

    @GetMapping("$URL/{id}")
    override fun procurarPorID(@PathVariable id: Int): ResponseEntity<Usuario> {
        return super.procurarPorID(id)
    }

    @GetMapping("$URL/buscar")
    override fun buscar(@RequestBody cnpjCpf: String): ResponseEntity<Usuario> {
        return super.buscar(cnpjCpf)
    }

    @PostMapping("$URL/AutenticarUsuario/")
    override fun autenticaUsuario(@RequestBody usuario: Usuario): Usuario? {
        return super.autenticaUsuario(usuario)
    }
}
