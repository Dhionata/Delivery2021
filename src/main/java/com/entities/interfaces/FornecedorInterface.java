package com.entities.interfaces;

import com.entities.classes.Fornecedor;
import com.entities.classes.ProdutoFornecedor;
import com.entities.classes.Telefone.TelefoneFornecedor;

public interface FornecedorInterface {
    public void adicionarProduto(ProdutoFornecedor produto);

    public void adicionarTelefone(TelefoneFornecedor telefone);

    public boolean confirmarPedido(int idPedido);

    public void removeProduto(ProdutoFornecedor produto);

    public void confirmarEntrega(int idPedido);

    public void atualizarStatusPedido(int idPedido);

    // Verificar!
    public Fornecedor buscarFornecedor(String nome);

    public boolean confirmarEstoque(int quantidadeEmEstoque);
}