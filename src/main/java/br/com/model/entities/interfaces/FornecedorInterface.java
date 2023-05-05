package br.com.model.entities.interfaces;

import br.com.model.entities.classes.Produto;
import br.com.model.entities.classes.ProdutoFornecedor;
import br.com.model.entities.classes.usuario.Fornecedor;

public interface FornecedorInterface {
    public void adicionarProduto(ProdutoFornecedor produto);

    public boolean confirmarPedido(int idPedido);

    public void removerProduto(ProdutoFornecedor produto);

    public void confirmarEntrega(int idPedido);

    public void atualizarStatusPedido(int idPedido);

    // Verificar!
    public Fornecedor buscarFornecedor(String nome);

    public boolean confirmarEstoque(int quantidadePedida, Produto produto);
}