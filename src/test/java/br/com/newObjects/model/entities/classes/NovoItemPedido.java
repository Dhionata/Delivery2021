package br.com.newObjects.model.entities.classes;

import java.util.Random;

import java.util.List;
import br.com.model.entities.classes.ItemPedido;
import br.com.model.entities.classes.Pedido;
import br.com.model.entities.classes.ProdutoFornecedor;

public class NovoItemPedido {

    public static void novaListaItensPedido(Pedido pedido,
            List<ProdutoFornecedor> produtoFornecedores) {

        new ItemPedido(pedido,
                produtoFornecedores.get(0).getProduto(),
                new Random().nextInt(10) + 1);

        new ItemPedido(pedido,
                produtoFornecedores.get(1).getProduto(),
                new Random().nextInt(10) + 1);
    }

    public static void novoItemPedido(Pedido pedido) {
        new ItemPedido(pedido, NovoProduto.novoProduto(), new Random().nextInt(10));
    }

}