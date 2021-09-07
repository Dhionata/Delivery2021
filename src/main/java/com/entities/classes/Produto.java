package com.entities.classes;

import java.sql.Date;

import com.entities.interfaces.ProdutoInterface;

public class Produto implements ProdutoInterface{

    int id;
    String nome;
    int idFornecedor;
    Float preco;
    Boolean status;
    int quantidadeEmEstoque;
    Date data;

    @Override
    public Produto buscarProduto(String nome) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
