package com.test;

import com.entities.classes.Cliente;
import com.entities.classes.FormaPagamento;
import com.entities.classes.ItemPedido;
import com.entities.classes.Pedido;
import com.entities.classes.Produto;

public class testePedido {
    public static void main(String[] args) {

        FormaPagamento formaPagamento = new FormaPagamento(200, "Débito");

        Cliente cliente = new Cliente(54, "NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");

        Produto produto = new Produto(67, "Abacate");
        Produto produto2 = new Produto(70, "Laranja");

        Pedido pedido = new Pedido(98, cliente, formaPagamento, 7.00f, false, false);

        ItemPedido itemPedido = new ItemPedido(17, pedido, produto, 4);
        ItemPedido itemPedido2 = new ItemPedido(18, pedido, produto2, 8);

        pedido.addItemPedido(itemPedido);
        pedido.addItemPedido(itemPedido2);

        System.out.println(pedido.toString());

    }
}
