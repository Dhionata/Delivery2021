package br.com.test.model.classes;

import java.util.ArrayList;
import java.util.List;

import br.com.model.entities.classes.Cliente;
import br.com.model.entities.classes.FormaPagamento;
import br.com.model.entities.classes.ItemPedido;
import br.com.model.entities.classes.Pedido;
import br.com.model.entities.classes.Produto;

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
