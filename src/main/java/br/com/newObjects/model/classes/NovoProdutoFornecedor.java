package br.com.newObjects.model.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.model.entities.classes.ProdutoFornecedor;
import br.com.model.entities.classes.Usuario.Fornecedor;

public class NovoProdutoFornecedor {

    public static List<ProdutoFornecedor> novaListaProdutosFornecedor(Fornecedor fornecedor) {
        ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor(NovoProduto.novoProduto(), fornecedor,
                new Random().nextFloat(), new Random().nextInt(1000));
        ProdutoFornecedor produtoFornecedor2 = new ProdutoFornecedor(NovoProduto.novoProduto2(), fornecedor,
                new Random().nextFloat(), new Random().nextInt(1000));

        List<ProdutoFornecedor> listaProdutoFornecedor = new ArrayList<ProdutoFornecedor>();
        listaProdutoFornecedor.add(produtoFornecedor);
        listaProdutoFornecedor.add(produtoFornecedor2);

        return listaProdutoFornecedor;
    }
}
