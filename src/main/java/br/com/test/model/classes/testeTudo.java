package br.com.test.model.classes;

import br.com.model.entities.classes.ItemPedido;

public class TesteTudo {

    public static void main(String[] args) {

        var p = TestePedido.novoPedido();

        for (ItemPedido itemPedido : p.getItensPedido()) {
            itemPedido.setPedido(p);
            itemPedido.getProduto().setListaProdutoFornecedores(TesteProdutoFornecedor.novaListaProdutosFornecedor(TesteFornecedor.novoFornecedor()));
            itemPedido.setAvaliacao(TesteAvaliacao.novaAvaliacao());
        }

        System.out.println(p.toString());
    }
}
