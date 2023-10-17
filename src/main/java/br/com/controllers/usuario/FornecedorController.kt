package br.com.controllers.usuario

import br.com.model.entities.classes.usuario.Fornecedor
import br.com.services.classes.usuario.FornecedorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
class FornecedorController(@Autowired private val fornecedorService: FornecedorService) {
    companion object {
        private const val URL = "/fornecedor"
    }

    @GetMapping(URL)
    fun procurarTodos(): ResponseEntity<MutableIterable<Fornecedor>> {
        return fornecedorService.procurarTodos()
    }

    @PostMapping(URL)
    @Throws(Exception::class)
    fun salvar(@RequestBody fornecedor: Fornecedor): ResponseEntity<Fornecedor>? {
        return fornecedorService.salvar(fornecedor)
    }

    @DeleteMapping(URL)
    @Throws(Exception::class)
    fun remover(@RequestBody fornecedor: Fornecedor): ResponseEntity<String>? {
        return fornecedorService.remover(fornecedor)
    }

    @PatchMapping(URL)
    @Throws(Exception::class)
    fun atualizar(@RequestBody fornecedor: Fornecedor): ResponseEntity<Fornecedor>? {
        return fornecedorService.atualizar(fornecedor)
    }

    @GetMapping("$URL/{id}")
    fun procurarPorID(@PathVariable id: Int?): ResponseEntity<Fornecedor>? {
        return fornecedorService.procurarPorID(id!!)
    }

    @GetMapping("$URL/Buscar")
    fun buscarPorCnpjCpf(@RequestBody fornecedor: Fornecedor): ResponseEntity<Fornecedor> {
        return fornecedorService.buscar(fornecedor.cnpjCpf)
    }

    @Throws(Exception::class)
    fun validate(fornecedor: Fornecedor) {
        if (fornecedor.email.isEmpty()) {
            throw Exception("\n\nEmail não pode ser vazio!\n\n")
        }
        if (fornecedor.nome.isEmpty()) {
            throw Exception("\n\nNome não pode ser vazio!\n\n")
        }
    }
}
