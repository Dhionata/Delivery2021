package br.com.test.model.classes;

import java.util.Random;

import br.com.model.entities.classes.Pedido;

public class testePedido {
    public static void main(String[] args) {
        System.out.println(novoPedido().toString());
    }

    public static Pedido novoPedido() {

        Pedido pedido = new Pedido(testeCliente.novoCliente(), testeFormaPagamento.novaFormaPagamento(),
                new Random().nextFloat(10), testeItemPedido.novaListaItensPedido());

        return pedido;
    }
}
