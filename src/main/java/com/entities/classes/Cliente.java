package com.entities.classes;

import java.util.Date;
import java.util.List;

import com.entities.classes.Telefone.Telefone;
import com.entities.interfaces.ClienteInterface;

public class Cliente implements ClienteInterface {
    private int id;
    private String nome;
    private String cnpjCpf;
    private String email;
    private String senha;
    private Date data;
    private Telefone telefone;

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
        return "\n--Cliente--\nCNPJ/CPF: " + getCnpjCpf() + "\nNome: " + getNome() + "\nData: " + getData()
                + "\nEmail: " + getEmail() + "\nID: " + getId() + "\nSenha: " + getSenha() + getTelefone();
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

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
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