package com.test.classes;

import com.entities.classes.Produto;

import java.util.ArrayList;
import java.util.List;

import com.entities.classes.Cliente;
import com.entities.classes.FormaPagamento;
import com.entities.classes.ItemPedido;
import com.entities.classes.Pedido;

public class testeItemPedido {
    public static void main(String[] args) {
        Produto produto = new Produto("Abacate");
        Produto produto2 = new Produto("Laranja");

        FormaPagamento formaPagamento = new FormaPagamento("Débito");

        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");

        Pedido pedido = new Pedido(cliente, formaPagamento, 7.00f, false, false);

        ItemPedido itemPedido = new ItemPedido(pedido, produto, 5);
        ItemPedido itemPedido2 = new ItemPedido(pedido, produto2, 6);

        List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
        itensPedido.add(itemPedido);
        itensPedido.add(itemPedido2);

        System.out.println(itensPedido.toString());

    }

}
