package br.com.controllers

import br.com.model.entities.classes.Produto
import br.com.services.GenericService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
class ProdutoController(@Autowired private val genericService: GenericService<Produto, Int>) {

    companion object {
        private const val URL = "/produto"
    }

    @GetMapping(value = [URL])
    @ResponseBody
    fun findAll(): Iterable<Produto> {
        return genericService.findAll()
    }

    @PostMapping(value = [URL])
    @Throws(Exception::class)
    fun save(@RequestBody produto: Produto): Produto {
        println("\n\n-- Entrou para salvar! --\n\n$produto\n\n\n")
        return genericService.save(produto)
    }

    @DeleteMapping(URL) // TODO verificar retorno, não está funcionando quando Object ou String
    @Throws(Exception::class)
    fun remove(@RequestBody produto: Produto) {
        println("\n\n-- Entrou para remover! --\n\n$produto\n\n\n")
        genericService.remove(produto)
    }

    @PatchMapping(URL)
    @Throws(Exception::class)
    private fun patch(@RequestBody produto: Produto): Produto {
        println("\n\n\n-- Entrou no Atualizar --\n\n$produto\n\n")
        return genericService.save(produto)
    }

    @GetMapping("$URL/{id}")
    fun findById(@PathVariable id: Int): Produto {
        println("\n\n-- Entrou para procurarPorID\nID: ! --\n\n$id\n\n\n")
        return genericService.findById(id)
    }

    @GetMapping("$URL/Buscar/")
    private fun find(@RequestBody produto: Produto): Produto {
        println("\n\n-- Entrou para procurar! --\n\n$produto\n\n\n")
        return genericService.findById(produto.id!!)
    }

    @Throws(Exception::class)
    fun validate(entity: Produto) {
        // TODO Auto-generated method stub
    }
}
