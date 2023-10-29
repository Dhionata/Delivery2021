package br.com.controllers.usuario

import br.com.model.usuario.Cliente
import br.com.services.classes.usuario.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
class ClienteController(@Autowired private val clienteService: ClienteService) {

    companion object {
        private const val URL = "/cliente"
    }

    @GetMapping(value = [URL])
    fun procurarTodos(): ResponseEntity<Iterable<Cliente>> {
        return clienteService.procurarTodos()
    }

    @PostMapping(value = [URL])
    @Throws(Exception::class)
    fun salvar(@RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        return clienteService.salvar(cliente)
    }

    @DeleteMapping(URL)
    @Throws(Exception::class)
    fun remover(@RequestBody cliente: Cliente): ResponseEntity<String> {
        return clienteService.remover(cliente)
    }

    @PatchMapping(URL)
    @Throws(Exception::class)
    fun atualizar(@RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        return clienteService.atualizar(cliente)
    }

    @GetMapping("$URL/{id}")
    fun procurarPorID(@PathVariable id: Int?): ResponseEntity<Cliente> {
        return clienteService.procurarPorID(id!!)
    }

    @GetMapping("$URL/Buscar")
    fun buscarPorCnpjCpf(@RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        return clienteService.buscarPorCnpjCpf(cliente.cnpjCpf)
    }

    @Throws(Exception::class)
    fun validate(entity: Cliente) {
        if (entity.email.isBlank()) {
            throw Exception("\n\nEmail não pode ser vazio!\n\n")
        }
        if (entity.nome.isBlank()) {
            throw Exception("\n\nNome não pode ser vazio!\n\n")
        }
    }
}
