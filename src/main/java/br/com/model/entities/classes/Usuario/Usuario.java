package br.com.model.entities.classes.usuario;

import java.util.ArrayList;
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
        setId(id);
        setCnpjCpf(cnpjCpf);
        setData(data);
        setNome(nome);
        setSenha(Criptografia.argon(senha));
        setEmail(email);
        setPedidos(pedidos);
        setEnderecos(enderecos);
    }

    public Usuario(String cnpjCpf, Date data, String nome, String senha, String email, TipoUsuario tipo,
            List<Endereco> enderecos,
            List<Pedido> pedidos) {
        setCnpjCpf(cnpjCpf);
        setData(data);
        setNome(nome);
        setSenha(Criptografia.argon(senha));
        setEmail(email);
        setTipo(tipo);
        setPedidos(pedidos);
        setEnderecos(enderecos);
    }

    public Usuario(String cnpjCpf, String nome, String senha, String email, TipoUsuario tipo) {
        setCnpjCpf(cnpjCpf);
        setData(new Date());
        setNome(nome);
        setSenha(Criptografia.argon(senha));
        setEmail(email);
        setTipo(tipo);
        setEnderecos(new ArrayList<Endereco>());
        setPedidos(new ArrayList<Pedido>());
        setTelefones(new ArrayList<Telefone>());
    }

    public Usuario(String cnpjCpf, String nome, String senha, String email) {
        setCnpjCpf(cnpjCpf);
        setData(new Date());
        setNome(nome);
        setSenha(Criptografia.argon(senha));
        setEmail(email);
        setEnderecos(new ArrayList<Endereco>());
        setPedidos(new ArrayList<Pedido>());
        setTelefones(new ArrayList<Telefone>());
    }

    public Usuario(Usuario usuario) {
        setId(usuario.getId());
        setCnpjCpf(usuario.getCnpjCpf());
        setData(new Date());
        setNome(usuario.getNome());
        setSenha(Criptografia.argon(usuario.getSenha()));
        setEmail(usuario.getEmail());
        setTipo(usuario.getTipo());
        setPedidos(usuario.getPedidos());
        setEnderecos(usuario.getEnderecos());
        setTelefones(usuario.getTelefones());
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "\n\n-- Usuario --\nID: " + getId() + "\nNome: " + getNome() + "\nEmail: " + getEmail() + "\nCNPJCPF: "
                + getCnpjCpf() + "\nData: " + getData() + "\nTipo de usuário: " + getTipo().name() + "\nSenha: "
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

    // Getters / Setters

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
