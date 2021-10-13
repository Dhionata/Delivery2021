package br.com.model.entities.classes.Usuario;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Integer id;
    private String cnpjCpf;
    private Date data;
    private String nome;
    private String senha;
    private List<Permissao> permissoes;

    @Override
    public String toString() {
        return "\n\n-- Usuario --\nID: " + getId() + "\nNome: " + "\nCNPJCPF: " + getCnpjCpf() + "\nData: " + getData()
                + getNome() + "\nPermissões: " + getPermissoes() + "\nSenha: " + getSenha();
    }

    // Getters / Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

}
