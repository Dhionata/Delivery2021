package com.entities.interfaces;

import com.entities.classes.Fornecedor;
import com.entities.classes.Produto;
import com.entities.classes.ProdutoFornecedor;
import com.entities.classes.Telefone.TelefoneFornecedor;

public interface FornecedorInterface {
    public void adicionarProduto(ProdutoFornecedor produto);

    public void adicionarTelefone(TelefoneFornecedor telefone);

    public boolean confirmarPedido(int idPedido);

    public void removeProduto(Produto produto);

    public void confirmarEntrega(int idPedido);

    public void atualizarStatusPedido(int idPedido);

    public Fornecedor buscarFornecedor(String nome);

    public boolean confirmarEstoque(int quantidadeEmEstoque);
}