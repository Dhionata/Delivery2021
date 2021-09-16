package com.entities.classes;

import java.util.Date;

import com.entities.interfaces.ProdutoFornecedorInterface;

public class ProdutoFornecedor implements ProdutoFornecedorInterface {
    private int id;
    private Produto produto;
    private Fornecedor fornecedor;
    private Float preco;
    private int quantidadeEmEstoque;
    private Date dataCadastro;
    private Date dataAtualizacao;

    public ProdutoFornecedor(Produto produto, Fornecedor fornecedor, Float preco, int quantidadeEmEstoque) {
        setProduto(produto);
        setFornecedor(fornecedor);
        setPreco(preco);
        setQuantidadeEmEstoque(quantidadeEmEstoque);
        setDataCadastro(new Date());
        fornecedor.adicionarProduto(this);
        produto.adicionarFornecedor(this);
    }

    @Override
    public String toString() {
        return "\n-- ProdutoFornecedor --\nID: " + getId() + "\nData de atualização: " + getDataAtualizacao()
                + "\nData de cadastro: " + getDataCadastro() + "\nFornecedor: " + getFornecedor().getNome()
                + "\nProduto: " + getProduto().getNome() + "\nQuantidade em estoque: " + getQuantidadeEmEstoque()
                + "\nPreço: " + getPreco();
    }

    @Override
    public Produto buscarProduto(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    // Getters/Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        setDataAtualizacao(new Date());
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        setDataAtualizacao(new Date());
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
        setDataAtualizacao(new Date());
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
        setDataAtualizacao(new Date());
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        setDataAtualizacao(new Date());
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
        setDataAtualizacao(new Date());
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

}
