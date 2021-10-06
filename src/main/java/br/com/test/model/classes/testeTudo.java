package br.com.test.model.classes;

import br.com.model.entities.classes.*;

public class testeTudo {

    public static void main(String[] args) {

        var p = testePedido.novoPedido();

        for (ItemPedido itemPedido : p.getItensPedido()) {
            itemPedido.setPedido(p);
            itemPedido.getProduto().setListaProdutoFornecedores(testeProdutoFornecedor.novaListaProdutosFornecedor(testeFornecedor.novoFornecedor()));
            itemPedido.setAvaliacao(testeAvaliacao.novaAvaliacao());
        }

        System.out.println(p.toString());
    }
}
