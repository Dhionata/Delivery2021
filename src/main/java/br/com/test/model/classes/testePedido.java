package br.com.test.model.classes;

import java.util.Random;

import br.com.model.entities.classes.FormaPagamento;
import br.com.model.entities.classes.Pedido;

public class TestePedido {
    public static void main(String[] args) {
        System.out.println(novoPedido().toString());
    }

    public static Pedido novoPedido() {

        Pedido pedido = new Pedido(TesteCliente.novoCliente(),
                FormaPagamento.novaFormaPagamento(new Random().nextInt(5)), new Random().nextFloat(10),
                TesteItemPedido.novaListaItensPedido());

        return pedido;
    }
}
