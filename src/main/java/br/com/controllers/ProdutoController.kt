package br.com.controllers

import br.com.model.Produto
import br.com.services.ProdutoService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
class ProdutoController(private val produtoService: ProdutoService) {

    companion object {
        private const val URL = "/produto"
    }

    @GetMapping(value = [URL])
    @ResponseBody
    fun findAll() = produtoService.findAll()


    @PostMapping(value = [URL])
    fun save(@RequestBody produto: Produto): Produto {
        println("\n\n-- Entrou para salvar! --\n\n$produto\n\n\n")
        return produtoService.save(produto)
    }

    @DeleteMapping(URL) // TODO verificar retorno, não está funcionando quando Object ou String
    fun remove(@RequestBody produto: Produto) {
        println("\n\n-- Entrou para remover! --\n\n$produto\n\n\n")
        produtoService.delete(produto)
    }

    @PatchMapping(URL)
    @Throws(Exception::class)
    private fun patch(@RequestBody produto: Produto): Produto {
        println("\n\n\n-- Entrou no Atualizar --\n\n$produto\n\n")
        return produtoService.save(produto)
    }

    @GetMapping("$URL/{id}")
    fun findById(@PathVariable id: Int): Produto {
        println("\n\n-- Entrou para procurarPorID\nID: ! --\n\n$id\n\n\n")
        return produtoService.findById(id)
    }

    @GetMapping("$URL/Buscar/")
    private fun find(@RequestBody produto: Produto): Produto {
        println("\n\n-- Entrou para procurar! --\n\n$produto\n\n\n")
        return produtoService.findById(produto.id!!)
    }
}
