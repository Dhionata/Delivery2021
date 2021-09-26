package br.com.model.entities.interfaces;

import br.com.model.entities.classes.Produto;

public interface ProdutoFornecedorInterface {
    public Produto buscarProduto(String nome);
}
