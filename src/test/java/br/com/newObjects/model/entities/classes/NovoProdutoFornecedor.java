package br.com.newObjects.model.entities.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.model.entities.classes.ProdutoFornecedor;
import br.com.model.entities.classes.usuario.Fornecedor;
import br.com.newObjects.model.entities.classes.usuario.NovoFornecedor;

public class NovoProdutoFornecedor {

    public static List<ProdutoFornecedor> novaListaProdutosFornecedor() {
        Fornecedor fornecedor = NovoFornecedor.novoFornecedor();

        ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor(NovoProduto.novoProduto(),
                fornecedor, new Random().nextFloat(), new Random().nextInt(1000));

        ProdutoFornecedor produtoFornecedor2 = new ProdutoFornecedor(NovoProduto.novoProduto2(),
                fornecedor, new Random().nextFloat(), new Random().nextInt(1000));

        List<ProdutoFornecedor> listaProdutoFornecedor = new ArrayList<ProdutoFornecedor>();
        listaProdutoFornecedor.add(produtoFornecedor);
        listaProdutoFornecedor.add(produtoFornecedor2);

        return listaProdutoFornecedor;
    }

    public static ProdutoFornecedor novoProdutoFornecedor() {
        Fornecedor fornecedor = NovoFornecedor.novoFornecedor();
        ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor(NovoProduto.novoProduto(), fornecedor,
                new Random().nextFloat(), new Random().nextInt(1000));
        return produtoFornecedor;
    }
}
