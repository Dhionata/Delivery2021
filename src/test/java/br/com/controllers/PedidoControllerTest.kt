package br.com.controllers

import br.com.model.Pedido
import br.com.newObjects.model.NovoPedido
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
open class PedidoControllerTest(@Autowired private val pedidoController: PedidoController) {
    @Test
    fun testFind() {
        var a: Pedido = NovoPedido.novoPedido()
        for (i in 0..4) {
            val b = pedidoController.save(NovoPedido.novoPedido())
            if (i == 3) {
                a = b
            }
        }
        println(pedidoController.findById(a.id!!))
    }

    @Test
    fun testFindAll() {
        for (i in 0..4) {
            pedidoController.save(NovoPedido.novoPedido())
        }
        println(pedidoController.findAll())
    }

    @Test
    fun testFindById() {
        var a = NovoPedido.novoPedido()
        for (i in 0..4) {
            val b = pedidoController.save(NovoPedido.novoPedido())
            if (i == 3) {
                a = b
            }
        }
        println(pedidoController.findById(a.id!!))
    }

    @Test
    fun testRemove() {
        val a = pedidoController.save(NovoPedido.novoPedido())
        pedidoController.remove(a)
    }

    @Test
    fun testSave() {
        val a = pedidoController.save(NovoPedido.novoPedido())
        assertEquals(a, pedidoController.findById(a.id!!))
    }

    @Test
    fun testUpdate() {
        val a = pedidoController.save(NovoPedido.novoPedido())
        a.pago = true
        pedidoController.save(a)
        assertEquals(a, pedidoController.findById(a.id!!))
    }
}
