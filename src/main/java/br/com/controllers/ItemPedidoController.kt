package br.com.controllers

import br.com.model.ItemPedido
import br.com.services.ItemPedidoService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
class ItemPedidoController(private val itemPedidoService: ItemPedidoService) {

    companion object {
        private const val URL = "/itemPedido"
    }

    @GetMapping(value = [URL])
    @ResponseBody
    private fun procurarTodos(): Iterable<ItemPedido> {
        return itemPedidoService.findAll()
    }

    @PostMapping(value = [URL])
    @Throws(Exception::class)
    private fun salvar(@RequestBody itemPedido: ItemPedido): ItemPedido {
        return itemPedidoService.save(itemPedido)
    }

    @DeleteMapping(URL)
    private fun remover(@RequestBody itemPedido: ItemPedido) {
        itemPedidoService.delete(itemPedido)
    }

    @PatchMapping(URL)
    @Throws(Exception::class)
    private fun atualizar(@RequestBody itemPedido: ItemPedido): ItemPedido {
        return itemPedidoService.save(itemPedido)
    }

    @GetMapping("$URL/{id}")
    private fun procurarPorID(@PathVariable id: Int): ItemPedido {
        return itemPedidoService.findById(id)
    }

    @GetMapping("$URL/Buscar/")
    private fun find(@RequestBody itemPedido: ItemPedido): ItemPedido {
        return itemPedidoService.findById(itemPedido.id!!)
    }
}
