package com.entities.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.entities.classes.Endereco.EnderecoCliente;
import com.entities.classes.Telefone.TelefoneCliente;
import com.entities.interfaces.ClienteInterface;

@Entity
public class Cliente implements ClienteInterface {
    @Id
    @GeneratedValue
    private Integer id;

    private String nome;
    private String cnpjCpf;
    private String email;
    private String senha;
    private Date data;

    @OneToMany(mappedBy = "cliente")
    private List<TelefoneCliente> listaTelefone;

    @OneToMany(mappedBy = "cliente")
    private List<EnderecoCliente> listaEndereco;

    public Cliente(String nome, String cnpjCpf, String email, String senha) {
        setNome(nome);
        setCnpjCpf(cnpjCpf);
        setEmail(email);
        setSenha(senha);
        setData(new Date());
        setListaTelefone(new ArrayList<TelefoneCliente>());
        setListaEndereco(new ArrayList<EnderecoCliente>());
    }

    @Override
    public String toString() {
        return "\n--Cliente--\nID: " + getId() + "\nNome: " + getNome() + "\nCNPJ/CPF: " + getCnpjCpf() + "\nData: "
                + getData() + "\nEmail: " + getEmail() + "\nSenha: " + getSenha() + "\n-- Lista de telefones --"
                + getListaTelefone() + "\n-- Lista de Endereços --" + getListaEndereco();
    }

    // verificar funcionalidade.
    @Override
    public void cadastrarEndereco(EnderecoCliente endereco) {
        getListaEndereco().add(endereco);
    }

    @Override
    public void removeEndereco(EnderecoCliente endereco) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean realizarPagamento(Float valor) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void listaPedidos(List<Pedido> pedidos) {
        // TODO Auto-generated method stub

    }

    @Override
    public void adicionarTelefone(TelefoneCliente telefone) {
        getListaTelefone().add(telefone);

    }
    // Getters/Setters

    public List<TelefoneCliente> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<TelefoneCliente> telefone) {
        this.listaTelefone = telefone;
    }

    public List<EnderecoCliente> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<EnderecoCliente> endereco) {
        this.listaEndereco = endereco;
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