package com.entities.classes;

import java.util.Date;
import java.util.List;

import com.entities.classes.Endereco.EnderecoFornecedor;
import com.entities.classes.Telefone.TelefoneFornecedor;
import com.entities.interfaces.FornecedorInterface;

public class Fornecedor implements FornecedorInterface {

    private int id;
    private String nome;
    private String descricao;
    private EnderecoFornecedor endereco;
    private String cnpjCpf;
    private Date data;
    private List<ProdutoFornecedor> listaProdutos;
    private List<TelefoneFornecedor> listaTelefones;

    public Fornecedor(int id, String nome, String descricao, String cnpjCpf) {
        setId(id);
        setNome(nome);
        setDescricao(descricao);
        setEndereco(endereco);
        setCnpjCpf(cnpjCpf);
        setData(new Date());
    }

    @Override
    public String toString() {
        return "\n--Fornecedor--\nNome: " + getNome() + "\nCNPJ/CPF: " + getCnpjCpf() + "\nData: " + getData()
                + "\nDescriçao: " + getDescricao() + getEndereco() + "\nID: " + getId() + getListaTelefones()
                + "\nLista de produtos: " + getListaProdutos();
    }

    @Override
    public void adicionarProduto(ProdutoFornecedor produto) {
        getListaProdutos().add(produto);

    }

    @Override
    public void adicionarTelefone(TelefoneFornecedor telefone) {
        getListaTelefones().add(telefone);

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

    // Verificar a possibilidade de uma lista de fornecedores.
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

    // Getters/Setters

    public List<TelefoneFornecedor> getListaTelefones() {
        return listaTelefones;
    }

    public void setListaTelefones(List<TelefoneFornecedor> telefone) {
        this.listaTelefones = telefone;
    }

    public void setListaProdutos(List<ProdutoFornecedor> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public List<ProdutoFornecedor> getListaProdutos() {
        return listaProdutos;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EnderecoFornecedor getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoFornecedor endereco) {
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

}