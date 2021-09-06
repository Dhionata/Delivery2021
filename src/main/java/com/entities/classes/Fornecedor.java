package com.entities.classes;

import com.entities.interfaces.FornecedorInterface;

public class Fornecedor implements FornecedorInterface{

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
    public Fornecedor buscarEmpresa(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean confirmarEstoque(int quantidadeEmEstoque) {
        // TODO Auto-generated method stub
        return false;
    }
    
}