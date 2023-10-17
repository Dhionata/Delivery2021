package br.com.controllers

import br.com.model.entities.classes.ItemPedido
import br.com.services.GenericService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
class ItemPedidoController(@Autowired private val genericService: GenericService<ItemPedido, Int>) {

    companion object {
        private const val URL = "/itemPedido"
    }

    @GetMapping(value = [URL])
    @ResponseBody
    private fun procurarTodos(): Iterable<ItemPedido> {
        return genericService.findAll()
    }

    @PostMapping(value = [URL])
    @Throws(Exception::class)
    private fun salvar(@RequestBody itemPedido: ItemPedido): ItemPedido {
        return genericService.save(itemPedido)
    }

    @DeleteMapping(URL)
    private fun remover(@RequestBody itemPedido: ItemPedido) {
        genericService.remove(itemPedido)
    }

    @PatchMapping(URL)
    @Throws(Exception::class)
    private fun atualizar(@RequestBody itemPedido: ItemPedido): ItemPedido {
        return genericService.save(itemPedido)
    }

    @GetMapping("$URL/{id}")
    private fun procurarPorID(@PathVariable id: Int): ItemPedido {
        return genericService.findById(id)
    }

    @GetMapping("$URL/Buscar/")
    private fun find(@RequestBody itemPedido: ItemPedido): ItemPedido {
        return genericService.findById(itemPedido.id!!)
    }

    @Throws(Exception::class)
    fun validate(entity: ItemPedido) {
        // TODO Auto-generated method stub
    }
}
