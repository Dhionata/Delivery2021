package com.entities.classes;

import java.util.Date;
import java.util.List;

import com.entities.interfaces.FornecedorInterface;

public class Fornecedor implements FornecedorInterface{

    int id;
    String nome;
    String descricao;
    Endereco endereco;
    String cnpjCpf;
    Date data;
    List<Produto> listaProdutos;

    @Override
    public void adicionarProduto(Produto produto) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean confirmarPedido(int idPedido) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeProduto(Produto produto) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void confirmarEntrega(int idPedido) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void atualizarStatusPedido(int idPedido) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Fornecedor buscarFornecedor(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean confirmarEstoque(int quantidadeEmEstoque) {
        // TODO Auto-generated method stub
        return false;
    }
    
}