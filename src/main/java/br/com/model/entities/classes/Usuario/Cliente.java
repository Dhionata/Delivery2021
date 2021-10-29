package br.com.model.entities.classes.Usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.model.entities.classes.Pedido;
import br.com.model.entities.classes.Endereco.EnderecoCliente;
import br.com.model.entities.classes.Telefone.TelefoneCliente;
import br.com.model.entities.interfaces.ClienteInterface;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Cliente extends Usuario implements ClienteInterface {

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TelefoneCliente> listaTelefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<EnderecoCliente> listaEndereco;

    public Cliente(String nome, String cnpjCpf, String senha, String email) {
        super(cnpjCpf, nome, senha, email);
        setListaTelefone(new ArrayList<TelefoneCliente>());
        setListaEndereco(new ArrayList<EnderecoCliente>());
        // falta permissões
    }

    public Cliente(String nome, String cnpjCpf, String email, String senha, List<TelefoneCliente> listaTelefones,
            List<EnderecoCliente> listaEnderecos, List<Permissao> permissoes) {
        super(cnpjCpf, nome, senha, email, permissoes);
        setListaEndereco(listaEndereco);
        setListaTelefone(listaTelefone);
    }

    public Cliente(Cliente cliente) {
        super(cliente.getId(), cliente.getCnpjCpf(), cliente.getData(), cliente.getNome(), cliente.getSenha(),
                cliente.getEmail(), cliente.getPermissoes());
        setListaEndereco(cliente.getListaEndereco());
        setListaTelefone(cliente.getListaTelefone());
    }

    public Cliente(Usuario usuario, List<EnderecoCliente> listaEndereco, List<TelefoneCliente> listaTelefone) {
        super(usuario);
        setListaEndereco(listaEndereco);
        setListaTelefone(listaTelefone);
    }

    public Cliente() {

    }

    @Override
    public String toString() {
        return "\n\n--Cliente--\nID: " + super.getId() + "\nNome: " + super.getNome() + "\nCNPJ/CPF: "
                + super.getCnpjCpf() + "\nData: " + super.getData() + "\nEmail: " + super.getEmail() + "\nSenha: "
                + super.getSenha() + "\n-- Lista de telefones --" + getListaTelefone() + "\n-- Lista de Endereços --"
                + getListaEndereco() + "\n-- Lista de Permissões --" + super.getPermissoes();
    }

    // verificar funcionalidade.
    @Override
    public void cadastrarEndereco(EnderecoCliente endereco) {
        getListaEndereco().add(endereco);
    }

    @Override
    public void removeEndereco(EnderecoCliente endereco) {
        getListaEndereco().remove(endereco);
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

    @Override
    public void removerTelefone(TelefoneCliente telefone) {
        getListaTelefone().remove(telefone);

    }
    // Getters and Setters

    public List<TelefoneCliente> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<TelefoneCliente> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    public List<EnderecoCliente> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<EnderecoCliente> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

}