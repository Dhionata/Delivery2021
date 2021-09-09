package com.entities.classes;

import java.util.Date;

import com.entities.interfaces.ProdutoInterface;

public class Produto implements ProdutoInterface {

    private int id;
    private String nome;
    private Fornecedor idFornecedor;
    private Float preco;
    private Boolean disponivel;
    private int quantidadeEmEstoque;
    private Date data;

    public Produto(int id, String nome, Fornecedor idFornecedor, Float preco, Boolean disponivel, int quantidadeEmEstoque) {
        setId(id);
        setNome(nome);
        setIdFornecedor(idFornecedor);
        setPreco(preco);
        setStatus(disponivel);
        setQuantidadeEmEstoque(quantidadeEmEstoque);
        setData(new Date());
    }

    @Override
    public String toString() {
        return "\n--Produto-- \nNome: " + nome + "\nID: " + getId() + "\nData: " + getData() + "\nFornecedor: "
                + getIdFornecedor().getNome() + "\nPreço: " + preco + "\nQuantidade em estoque: " + getQuantidadeEmEstoque()
                + "\nStatus: " + getStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Boolean getStatus() {
        return disponivel;
    }

    public void setStatus(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    // verificar a possibilidade de instanciar fornecedor e buscar da lista de
    // produtos.
    @Override
    public Produto buscarProduto(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

}
