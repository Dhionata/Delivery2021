package br.com.newObjects.model.entities.classes;

import java.util.Random;

import br.com.model.entities.classes.FormaPagamento;
import br.com.model.entities.classes.Pedido;
import br.com.newObjects.model.entities.classes.usuario.NovoCliente;

public class NovoPedido {

    public static Pedido novoPedido() {

        Pedido pedido = new Pedido(NovoCliente.novoCliente(),
                FormaPagamento.novaFormaPagamento(new Random().nextInt(5) + 1),
                new Random().nextFloat(10));

        NovoItemPedido.novaListaItensPedido(pedido,
                NovoProdutoFornecedor.novaListaProdutosFornecedor());

        NovaAvaliacao.novaAvaliacao(pedido);

        return pedido;
    }

    public static Pedido novoPedidoSimples() {
        return new Pedido(NovoCliente.novoCliente(), FormaPagamento.novaFormaPagamento(new Random().nextInt(5) + 1),
                new Random().nextFloat(100) + 1);
    }
}
