package br.com.model.entities.interfaces;

import br.com.model.entities.classes.ProdutoFornecedor;
import br.com.model.entities.classes.telefone.TelefoneFornecedor;
import br.com.model.entities.classes.usuario.Fornecedor;

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