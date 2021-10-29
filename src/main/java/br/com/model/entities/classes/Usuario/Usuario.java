package br.com.model.entities.classes.Usuario;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.com.encrypt.Criptografia;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @GeneratedValue
    private Integer id;
    private String cnpjCpf;
    private Date data;
    private String nome;
    private String senha;
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.ORDINAL)
    private List<Permissao> permissoes;

    public Usuario(Integer id, String cnpjCpf, Date data, String nome, String senha, String email,
            List<Permissao> permissoes) {
        setId(id);
        setCnpjCpf(cnpjCpf);
        setData(data);
        setNome(nome);
        setSenha(Criptografia.argon(senha));
        setEmail(email);
        setPermissoes(permissoes);
    }

    public Usuario(String cnpjCpf, Date data, String nome, String senha, String email, List<Permissao> permissoes) {
        setCnpjCpf(cnpjCpf);
        setData(data);
        setNome(nome);
        setSenha(Criptografia.argon(senha));
        setEmail(email);
        setPermissoes(permissoes);
    }

    public Usuario(String cnpjCpf, String nome, String senha, String email, List<Permissao> permissoes) {
        setCnpjCpf(cnpjCpf);
        setData(new Date());
        setNome(nome);
        setSenha(Criptografia.argon(senha));
        setEmail(email);
        setPermissoes(permissoes);
    }

    public Usuario(String cnpjCpf, String nome, String senha, String email) {
        setCnpjCpf(cnpjCpf);
        setData(new Date());
        setNome(nome);
        setSenha(Criptografia.argon(senha));
        setEmail(email);
    }

    public Usuario(Usuario usuario) {
        setId(usuario.getId());
        setCnpjCpf(usuario.getCnpjCpf());
        setData(usuario.getData());
        setNome(usuario.getNome());
        setSenha(Criptografia.argon(usuario.getSenha()));
        setEmail(usuario.getEmail());
        setPermissoes(usuario.getPermissoes());
    }

    public Usuario() {

    }

    @Override
    public String toString() {
        return "\n\n-- Usuario --\nID: " + getId() + "\nNome: " + "\nEmail: " + getEmail() + "\nCNPJCPF: "
                + getCnpjCpf() + "\nData: " + getData() + getNome() + "\nPermissões: " + getPermissoes() + "\nSenha: "
                + getSenha();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
