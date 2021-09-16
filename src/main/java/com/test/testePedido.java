package com.test;

import com.entities.classes.Cliente;
import com.entities.classes.FormaPagamento;
import com.entities.classes.ItemPedido;
import com.entities.classes.Pedido;
import com.entities.classes.Produto;

public class testePedido {
    public static void main(String[] args) {

        FormaPagamento formaPagamento = new FormaPagamento("Débito");

        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");

        Produto produto = new Produto("Abacate");
        Produto produto2 = new Produto("Laranja");

        Pedido pedido = new Pedido(cliente, formaPagamento, 7.00f, false, false);

        ItemPedido itemPedido = new ItemPedido(pedido, produto, 4);
        ItemPedido itemPedido2 = new ItemPedido(pedido, produto2, 8);

        System.out.println(pedido.toString());

    }
}
