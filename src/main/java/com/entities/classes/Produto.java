package com.entities.classes;

import java.util.Date;

import com.entities.interfaces.ProdutoInterface;

public class Produto implements ProdutoInterface {

    private int id;
    private String nome;
    private Fornecedor fornecedor;
    private Float preco;
    private Boolean disponivel = true;
    private int quantidadeEmEstoque;
    private Date data;

    public Produto(int id, String nome, Fornecedor fornecedor, Float preco, int quantidadeEmEstoque) {
        setId(id);
        setNome(nome);
        setFornecedor(fornecedor);
        setPreco(preco);
        setStatus(disponivel);
        setQuantidadeEmEstoque(quantidadeEmEstoque);
        setData(new Date());
    }

    public Produto(int id, String nome, Float preco, int quantidadeEmEstoque) {
        setId(id);
        setNome(nome);
        setPreco(preco);
        setStatus(disponivel);
        setQuantidadeEmEstoque(quantidadeEmEstoque);
        setData(new Date());
    }

    @Override
    public String toString() {
        return "\n--Produto--\nNome: " + getNome() + "\nID: " + getId() + "\nData: " + getData() + "\nFornecedor: "
                + getNomeDoFornecedor() + "\nPreço: " + getPreco() + "\nStatus: " + getStatus()
                + "\nQuantidade em estoque: " + getQuantidadeEmEstoque();
    }

    // verificar a possibilidade de instanciar fornecedor e buscar da lista de
    // produtos.
    @Override
    public Produto buscarProduto(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    public String getNomeDoFornecedor() {
        if (getIdFornecedor() != null) {
            return getIdFornecedor().getNome();
        } else {
            return "Sem Fornecedor!";
        }
    }

    // Getters/Setters

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
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
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
}
