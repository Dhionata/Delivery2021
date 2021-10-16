
package br.com.test.controllers.repository;

import br.com.repository.PedidoRepository;
import br.com.test.model.classes.TestePedido;
import br.com.model.entities.classes.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteTudoRepository {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping(value = "/testeTudo")
    public Iterable<Pedido> post() {

        TestePedido.novoPedido();

        // Salva todos os dados em cascata (cascade = CascadeType.ALL) em todas às
        // referências em árvore de Pedido.

        return pedidoRepository.findAll();
    }
}