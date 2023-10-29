package br.com.controllers

import br.com.model.Pedido
import br.com.services.PedidoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
open class PedidoController(@field:Autowired private val pedidoService: PedidoService) {

    companion object {
        private const val URL = "/pedido"
    }

    @GetMapping(value = [URL])
    @ResponseBody
    fun findAll() = pedidoService.findAll()

    @PostMapping(value = [URL])
    fun save(@RequestBody pedido: Pedido): Pedido {
        return pedidoService.save(pedido)
    }

    @DeleteMapping(URL)
    fun remove(@RequestBody pedido: Pedido) {
        pedidoService.delete(pedido)
    }

    @PatchMapping(URL)
    private fun patch(@RequestBody pedido: Pedido): Pedido {
        return pedidoService.save(pedido)
    }

    @GetMapping("$URL/{id}")
    fun findById(@PathVariable id: Int): Pedido {
        return pedidoService.findById(id)
    }

    @GetMapping("$URL/Buscar/")
    private fun find(@RequestBody pedido: Pedido): Pedido {
        return pedidoService.findById(pedido.id!!)
    }

    private fun validate(entity: Pedido) {
        if (entity.itensPedido.isEmpty()) {
            throw Exception("Pedido não pode ser salvo sem itens")
        }
    }

    @GetMapping("$URL/ValorTotal/{id}")
    private fun valorTotal(@PathVariable id: Int): Float {
        return pedidoService.findById(id).calculaValorTotal()
    }
}
