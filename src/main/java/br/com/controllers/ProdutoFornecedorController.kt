package br.com.controllers

import br.com.model.entities.classes.ProdutoFornecedor
import br.com.services.GenericService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = [""])
class ProdutoFornecedorController(@Autowired private val genericService: GenericService<ProdutoFornecedor, Int>) {
    companion object {
        private const val URL = "/produtoFornecedor"
    }

    @GetMapping(value = [URL])
    @ResponseBody
    fun findAll(): Iterable<ProdutoFornecedor> {
        return genericService.findAll()
    }

    @PostMapping(value = [URL])
    @Throws(Exception::class)
    fun save(@RequestBody produtoFornecedor: ProdutoFornecedor): ProdutoFornecedor {
        return genericService.save(produtoFornecedor)
    }

    @DeleteMapping(URL)
    private fun remove(@RequestBody produtoFornecedor: ProdutoFornecedor) {
        genericService.remove(produtoFornecedor)
    }

    @PatchMapping(URL)
    @Throws(Exception::class)
    private fun patch(@RequestBody produtoFornecedor: ProdutoFornecedor): ProdutoFornecedor {
        return genericService.save(produtoFornecedor)
    }

    @GetMapping("$URL/{id}")
    private fun findById(@PathVariable id: Int): ProdutoFornecedor {
        return genericService.findById(id)
    }

    @GetMapping("$URL/Buscar/")
    private fun find(@RequestBody produtoFornecedor: ProdutoFornecedor): ProdutoFornecedor {
        return genericService.findById(produtoFornecedor.id!!)
    }

    @Throws(Exception::class)
    fun validate(produtoFornecedor: ProdutoFornecedor) {
        if (produtoFornecedor.quantidadeEmEstoque == 0) {
            throw Exception("Quantidade em estoque não pode ser nulo")
        }
    }
}
