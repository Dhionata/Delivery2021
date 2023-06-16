package br.com.model.entities.classes.usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.encrypt.Criptografia;
import br.com.model.entities.classes.Endereco;
import br.com.model.entities.classes.Pedido;
import br.com.model.entities.classes.Telefone;
import br.com.model.entities.interfaces.UsuarioInterface;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements UsuarioInterface {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String cnpjCpf;
    private Date data;
    private String nome;
    private String senha;
    private String email;
    private TipoUsuario tipo;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pedido> pedidos;

    public Usuario(Integer id, String cnpjCpf, Date data, String nome, String senha, String email, TipoUsuario tipo,
            List<Endereco> enderecos, List<Pedido> pedidos) {
        this.id = id;
        this.cnpjCpf = cnpjCpf;
        this.data = data;
        this.nome = nome;
        this.senha = Criptografia.argon(senha);
        this.email = email;
        this.pedidos = pedidos;
        this.enderecos = enderecos;
    }

    public Usuario(String cnpjCpf, Date data, String nome, String senha, String email, TipoUsuario tipo,
            List<Endereco> enderecos,
            List<Pedido> pedidos) {
        this.cnpjCpf = cnpjCpf;
        this.data = data;
        this.nome = nome;
        this.senha = Criptografia.argon(senha);
        this.email = email;
        this.tipo = tipo;
        this.pedidos = pedidos;
        this.enderecos = enderecos;
    }

    public Usuario(String cnpjCpf, String nome, String senha, String email, TipoUsuario tipo) {
        this.cnpjCpf = cnpjCpf;
        this.data = new Date();
        this.nome = nome;
        this.senha = Criptografia.argon(senha);
        this.email = email;
        this.tipo = tipo;
        this.enderecos = new ArrayList<Endereco>();
        this.pedidos = new ArrayList<Pedido>();
        this.telefones = new ArrayList<Telefone>();
    }

    public Usuario(String cnpjCpf, String nome, String senha, String email) {
        this.cnpjCpf = cnpjCpf;
        this.data = new Date();
        this.nome = nome;
        this.senha = Criptografia.argon(senha);
        this.email = email;
        this.enderecos = new ArrayList<Endereco>();
        this.pedidos = new ArrayList<Pedido>();
        this.telefones = new ArrayList<Telefone>();
    }

    public Usuario(Usuario usuario) {
        this.id = usuario.getId();
        this.cnpjCpf = usuario.getCnpjCpf();
        this.data = new Date();
        this.nome = usuario.getNome();
        this.senha = Criptografia.argon(usuario.getSenha());
        this.email = usuario.getEmail();
        this.tipo = usuario.getTipo();
        this.pedidos = usuario.getPedidos();
        this.enderecos = usuario.getEnderecos();
        this.telefones = usuario.getTelefones();
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "\n\n-- Usuario --\nID: " + getId() + "\nNome: " + getNome() + "\nEmail: " + getEmail() + "\nCNPJCPF: "
                + getCnpjCpf() + "\nData: " + getData() + "\nTipo de usuário: " + tipo.name() + "\nSenha: "
                + getSenha();
    }

    @Override
    public void cadastrarEndereco(Endereco endereco) {
        getEnderecos().add(endereco);
    }

    @Override
    public void removerEndereco(Endereco endereco) {
        getEnderecos().remove(endereco);
    }

    @Override
    public void adicionarTelefone(Telefone telefone) {
        getTelefones().add(telefone);
    }

    @Override
    public void removerTelefone(Telefone telefone) {
        getTelefones().remove(telefone);
    }

    // Getters / this.ters

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
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
