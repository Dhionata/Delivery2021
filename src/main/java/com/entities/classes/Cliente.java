package com.entities.classes;

import java.util.Date;
import java.util.List;

import com.entities.interfaces.ClienteInterface;

public class Cliente implements ClienteInterface {
    private int id;
    private String nome;
    private String cnpjCpf;
    private String email;
    private String senha;
    private Date data;

    public Cliente(int id, String nome, String cnpjCpf, String email, String senha) {
        setId(id);
        setNome(nome);
        setCnpjCpf(cnpjCpf);
        setEmail(email);
        setSenha(senha);
        setData(new Date());
    }

    @Override
    public String toString() {
        return "\n--Cliente--\nCNPJ/CPF: " + cnpjCpf + "\nData: " + data + "\nEmail: " + email + "\nID: " + id
                + "\nNome: " + nome + "\nSenha: " + senha;
    }

    @Override
    public void cadastrarEndereco(Endereco endereco) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeEndereco(Endereco endereco) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean realizarPagamento(Float valor) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void listaPedido(List<Pedido> pedidos) {
        // TODO Auto-generated method stub

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

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}