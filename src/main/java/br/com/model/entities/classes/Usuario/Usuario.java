package br.com.model.entities.classes.usuario;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.encrypt.Criptografia;
import br.com.model.entities.classes.Pedido;

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
    private TipoUsuario tipo;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pedido> pedidos;

    public Usuario(Integer id, String cnpjCpf, Date data, String nome, String senha, String email,
            TipoUsuario tipo) {
        setId(id);
        setCnpjCpf(cnpjCpf);
        setData(data);
        setNome(nome);
        setSenha(Criptografia.argon(senha));
        setEmail(email);
    }

    public Usuario(String cnpjCpf, Date data, String nome, String senha, String email, TipoUsuario tipo) {
        setCnpjCpf(cnpjCpf);
        setData(data);
        setNome(nome);
        setSenha(Criptografia.argon(senha));
        setEmail(email);
        setTipo(tipo);
    }

    public Usuario(String cnpjCpf, String nome, String senha, String email, TipoUsuario tipo) {
        setCnpjCpf(cnpjCpf);
        setData(new Date());
        setNome(nome);
        setSenha(Criptografia.argon(senha));
        setEmail(email);
        setTipo(tipo);
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
        setData(new Date());
        setNome(usuario.getNome());
        setSenha(Criptografia.argon(usuario.getSenha()));
        setEmail(usuario.getEmail());
        setTipo(usuario.getTipo());
    }

    public Usuario() {
        setData(new Date());
    }

    @Override
    public String toString() {
        return "\n\n-- Usuario --\nID: " + getId() + "\nNome: " + "\nEmail: " + getEmail() + "\nCNPJCPF: "
                + getCnpjCpf() + "\nData: " + getData() + getNome() + "\nTipo de usuário: " + getTipo() + "\nSenha: "
                + getSenha();
    }

    // Getters / Setters

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

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
}
