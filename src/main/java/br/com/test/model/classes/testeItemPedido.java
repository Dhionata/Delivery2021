package br.com.test.model.classes;

import java.util.ArrayList;
import java.util.Random;

import java.util.List;
import br.com.model.entities.classes.ItemPedido;

public class TesteItemPedido {
    public static void main(String[] args) {
        System.out.println(novaListaItensPedido().toString());

    }

    public static List<ItemPedido> novaListaItensPedido() {
        ItemPedido itemPedido = new ItemPedido(TesteProduto.novoProduto(), new Random().nextInt(10));
        ItemPedido itemPedido2 = new ItemPedido(TesteProduto.novoProduto2(), new Random().nextInt(10));

        List<ItemPedido> novaListaItensPedido = new ArrayList<>();
        novaListaItensPedido.add(itemPedido);
        novaListaItensPedido.add(itemPedido2);
        return novaListaItensPedido;
    }

    public static ItemPedido novoItemPedido() {
        return new ItemPedido(TesteProduto.novoProduto(), new Random().nextInt(10));
    }

}
