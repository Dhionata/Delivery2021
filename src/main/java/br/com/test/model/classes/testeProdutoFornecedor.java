package br.com.test.model.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.model.entities.classes.Fornecedor;
import br.com.model.entities.classes.ProdutoFornecedor;

public class testeProdutoFornecedor {
    public static void main(String[] args) {
        // public ProdutoFornecedor(Produto produto, Fornecedor fornecedor, Float preco,
        // int quantidadeEmEstoque)

        System.out.println(novaListaProdutosFornecedor(testeFornecedor.novoFornecedor()).toString());
    }

    public static List<ProdutoFornecedor> novaListaProdutosFornecedor(Fornecedor fornecedor) {
        ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor(testeProduto.novoProduto(), fornecedor,
                new Random().nextFloat(), new Random().nextInt(1000));
        ProdutoFornecedor produtoFornecedor2 = new ProdutoFornecedor(testeProduto.novoProduto2(), fornecedor,
                new Random().nextFloat(), new Random().nextInt(1000));

        List<ProdutoFornecedor> listaProdutoFornecedor = new ArrayList<ProdutoFornecedor>();
        listaProdutoFornecedor.add(produtoFornecedor);
        listaProdutoFornecedor.add(produtoFornecedor2);

        return listaProdutoFornecedor;
    }
}
