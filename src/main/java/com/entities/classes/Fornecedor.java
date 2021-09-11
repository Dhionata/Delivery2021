package com.entities.classes;

import java.util.Date;
import java.util.List;

import com.entities.interfaces.FornecedorInterface;

public class Fornecedor implements FornecedorInterface {

    private int id;
    private String nome;
    private String descricao;
    private Endereco endereco;
    private String cnpjCpf;
    private Date data;
    private List<Produto> listaProdutos;

    public Fornecedor(int id, String nome, String descricao, Endereco endereco, String cnpjCpf) {
        setId(id);
        setNome(nome);
        setDescricao(descricao);
        setEndereco(endereco);
        setCnpjCpf(cnpjCpf);
        setData(new Date());
    }

    // Verificar a possibilidade de uma lista de empresas.
    @Override
    public Fornecedor buscarFornecedor(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "\n--Fornecedor--\nNome: " + getNome() + "\nCNPJ/CPF: " + cnpjCpf + "\nData: " + getData()
                + "\nDescriçao: " + getDescricao() + endereco + "\nID: " + id + "\nLista de produtos: "
                + getListaProdutos();
    }

    @Override
    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);

    }

    @Override
    public boolean confirmarPedido(int idPedido) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeProduto(Produto produto) {
        listaProdutos.remove(produto);

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
    public boolean confirmarEstoque(int quantidadeEmEstoque) {
        // TODO Auto-generated method stub
        return false;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

}