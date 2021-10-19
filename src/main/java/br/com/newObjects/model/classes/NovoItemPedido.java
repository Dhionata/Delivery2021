package br.com.newObjects.model.classes;

import java.util.ArrayList;
import java.util.Random;

import java.util.List;
import br.com.model.entities.classes.ItemPedido;
import br.com.model.entities.classes.Pedido;

public class NovoItemPedido {

    public static List<ItemPedido> novaListaItensPedido(Pedido pedido) {
        ItemPedido itemPedido = new ItemPedido(pedido, NovoProduto.novoProduto(), new Random().nextInt(10));
        ItemPedido itemPedido2 = new ItemPedido(pedido, NovoProduto.novoProduto2(), new Random().nextInt(10));

        List<ItemPedido> novaListaItensPedido = new ArrayList<>();
        novaListaItensPedido.add(itemPedido);
        novaListaItensPedido.add(itemPedido2);
        return novaListaItensPedido;
    }

    public static ItemPedido novoItemPedido(Pedido pedido) {
        return new ItemPedido(pedido, NovoProduto.novoProduto(), new Random().nextInt(10));
    }

}