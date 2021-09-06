package com.entities.interfaces;

import com.entities.classes.Fornecedor;
import com.entities.classes.Produto;

public interface FornecedorInterface {
    public void adicionarProduto(Produto produto);
    public boolean confirmarPedido(int idPedido);
    public void removeProduto(Produto produto);
    public void confirmarEntrega(int idPedido);
    public void atualizarStatusPedido(int idPedido);
    public Fornecedor buscarFornecedor(String nome); // alterado para para buscarFornecedor //
    public boolean confirmarEstoque(int quantidadeEmEstoque);

}
