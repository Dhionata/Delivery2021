package br.com.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.model.entities.classes.Pedido;
import br.com.test.model.classes.TestePedido;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PedidoControllerTest {

    @Autowired
    private PedidoController pedidoController;

    @Test
    void testFind() throws Exception {
        var a = new Pedido();
        for (int i = 0; i <= 5; i++) {
            var b = pedidoController.save(TestePedido.novoPedido());
            if (i == 3) {
                a = b;
            }
        }
        System.out.println(pedidoController.find(a));
    }

    @Test
    void testFindAll() throws Exception {
        for (int i = 0; i <= 5; i++) {
            pedidoController.save(TestePedido.novoPedido());
        }
        System.out.println(pedidoController.findAll());
    }

    @Test
    void testFindById() throws Exception {
        var a = new Pedido();
        for (int i = 0; i <= 5; i++) {
            var b = pedidoController.save(TestePedido.novoPedido());
            if (i == 3) {
                a = b;
            }
        }
        System.out.println(pedidoController.findById(a.getId()));
    }

    @Test
    void testRemove() throws Exception {
        var a = pedidoController.save(TestePedido.novoPedido());
        pedidoController.remove(a);
    }

    @Test
    void testSave() throws Exception {
        var a = pedidoController.save(TestePedido.novoPedido());
        assertEquals(a, pedidoController.find(a));
    }

    @Test
    void testUpdate() throws Exception {
        var a = pedidoController.save(TestePedido.novoPedido());
        a.setPago(true);
        pedidoController.update(a);
        assertEquals(a, pedidoController.find(a));

    }
}
