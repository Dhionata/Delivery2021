package br.com.test.model.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.model.entities.classes.ProdutoFornecedor;
import br.com.model.entities.classes.Usuario.Fornecedor;

public class TesteProdutoFornecedor {
    public static void main(String[] args) {
        // public ProdutoFornecedor(Produto produto, Fornecedor fornecedor, Float preco,
        // int quantidadeEmEstoque)

        System.out.println(novaListaProdutosFornecedor(TesteFornecedor.novoFornecedor()).toString());
    }

    public static List<ProdutoFornecedor> novaListaProdutosFornecedor(Fornecedor fornecedor) {
        ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor(TesteProduto.novoProduto(), fornecedor,
                new Random().nextFloat(), new Random().nextInt(1000));
        ProdutoFornecedor produtoFornecedor2 = new ProdutoFornecedor(TesteProduto.novoProduto2(), fornecedor,
                new Random().nextFloat(), new Random().nextInt(1000));

        List<ProdutoFornecedor> listaProdutoFornecedor = new ArrayList<ProdutoFornecedor>();
        listaProdutoFornecedor.add(produtoFornecedor);
        listaProdutoFornecedor.add(produtoFornecedor2);

        return listaProdutoFornecedor;
    }
}
