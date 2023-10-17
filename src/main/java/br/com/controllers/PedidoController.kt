package br.com.controllers

import br.com.model.entities.classes.Pedido
import br.com.services.GenericService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
class PedidoController(@Autowired private val genericService: GenericService<Pedido, Int>) {

    companion object {
        private const val URL = "/pedido"
    }

    @GetMapping(value = [URL])
    @ResponseBody
    fun findAll(): Iterable<Pedido> {
        return genericService.findAll()
    }

    @PostMapping(value = [URL])
    @Throws(Exception::class)
    fun save(@RequestBody pedido: Pedido): Pedido {
        return genericService.save(pedido)
    }

    @DeleteMapping(URL)
    fun remove(@RequestBody pedido: Pedido) {
        genericService.remove(pedido)
    }

    @PatchMapping(URL)
    @Throws(Exception::class)
    private fun patch(@RequestBody pedido: Pedido): Pedido {
        return genericService.save(pedido)
    }

    @GetMapping("$URL/{id}")
    fun findById(@PathVariable id: Int): Pedido {
        return genericService.findById(id)
    }

    @GetMapping("$URL/Buscar/")
    private fun find(@RequestBody pedido: Pedido): Pedido {
        return genericService.findById(pedido.id!!)
    }

    @Throws(Exception::class)
    private fun validate(entity: Pedido) {
        if (entity.itensPedido!!.isEmpty()) {
            throw Exception("Pedido não pode ser salvo sem itens")
        }
        if (entity.cliente == null) {
            throw Exception("Pedido não pode ser salvo sem cliente")
        }
        if (entity.formaPagamento == null) {
            throw Exception("Pedido não pode ser salvo sem forma de pagamento")
        }
    }

    @GetMapping("$URL/ValorTotal/{id}")
    private fun valorTotal(@PathVariable id: Int): Float {
        return genericService.findById(id).calculaValorTotal()
    }
}
