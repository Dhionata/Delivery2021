package com.test;

import com.entities.classes.Produto;

import java.util.ArrayList;
import java.util.List;

import com.entities.classes.Cliente;
import com.entities.classes.FormaPagamento;
import com.entities.classes.ItemPedido;
import com.entities.classes.Pedido;

public class testeItemPedido {
    public static void main(String[] args) {
        Produto produto = new Produto(1, "Abacate");
        Produto produto2 = new Produto(70, "Laranja");

        FormaPagamento formaPagamento = new FormaPagamento(200, "Débito");

        Cliente cliente = new Cliente(54, "NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");

        Pedido pedido = new Pedido(98, cliente, formaPagamento, 7.00f, false, false);

        ItemPedido itemPedido = new ItemPedido(1, pedido, produto, 5);
        ItemPedido itemPedido2 = new ItemPedido(2, pedido, produto2, 6);

        List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
        itensPedido.add(itemPedido);
        itensPedido.add(itemPedido2);

        // System.out.println(itensPedido);
        System.out.println(cliente.toString());

    }

}
