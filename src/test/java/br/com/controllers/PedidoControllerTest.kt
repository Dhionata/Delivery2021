package br.com.controllers

import br.com.model.entities.classes.Pedido
import br.com.newObjects.model.entities.classes.NovoPedido
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PedidoControllerTest(@Autowired private val pedidoController: PedidoController) {
    @Test
    @Throws(Exception::class)
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
    @Throws(Exception::class)
    fun testFindAll() {
        for (i in 0..4) {
            pedidoController.save(NovoPedido.novoPedido())
        }
        println(pedidoController.findAll())
    }

    @Test
    @Throws(Exception::class)
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
    @Throws(Exception::class)
    fun testRemove() {
        val a = pedidoController.save(NovoPedido.novoPedido())
        pedidoController.remove(a)
    }

    @Test
    @Throws(Exception::class)
    fun testSave() {
        val a = pedidoController.save(NovoPedido.novoPedido())
        assertEquals(a, pedidoController.findById(a.id!!))
    }

    @Test
    @Throws(Exception::class)
    fun testUpdate() {
        val a = pedidoController.save(NovoPedido.novoPedido())
        a.pago = true
        pedidoController.save(a)
        assertEquals(a, pedidoController.findById(a.id!!))
    }
}
