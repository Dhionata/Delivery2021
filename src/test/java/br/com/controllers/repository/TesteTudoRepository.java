package br.com.controllers.repository;

import br.com.repository.PedidoRepository;
import br.com.model.entities.classes.Pedido;
import br.com.newObjects.model.classes.NovoPedido;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TesteTudoRepository {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Test
    void post() {

        Pedido entity = NovoPedido.novoPedido();
        pedidoRepository.save(entity);
        // Salva todos os dados em cascata (cascade = CascadeType.ALL) em todas às
        // referências em árvore de Pedido.

        System.out.println(pedidoRepository.findAll());
    }
}