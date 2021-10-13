package br.com.model.entities.classes.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import br.com.encrypt.Criptografia;
import br.com.model.entities.classes.Pedido;
import br.com.model.entities.classes.Endereco.EnderecoCliente;
import br.com.model.entities.classes.Telefone.TelefoneCliente;
import br.com.model.entities.interfaces.ClienteInterface;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Cliente extends Usuario implements ClienteInterface {

    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<TelefoneCliente> listaTelefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<EnderecoCliente> listaEndereco;

    public Cliente(String nome, String cnpjCpf, String email, String senha) {
        super.setNome(nome);
        super.setCnpjCpf(cnpjCpf);
        setEmail(email);
        super.setSenha(Criptografia.argon(senha));
        super.setData(new Date());
        setListaTelefone(new ArrayList<TelefoneCliente>());
        setListaEndereco(new ArrayList<EnderecoCliente>());
    }

    public Cliente(String nome, String cnpjCpf, String email, String senha, List<TelefoneCliente> listaTelefones,
            List<EnderecoCliente> listaEnderecos) {
        super.setNome(nome);
        super.setCnpjCpf(cnpjCpf);
        setEmail(email);
        super.setSenha(Criptografia.argon(senha));
        super.setData(new Date());
        setListaEndereco(listaEndereco);
        setListaTelefone(listaTelefone);
    }

    public Cliente(Cliente cliente) {
        super.setId(cliente.getId());
        super.setCnpjCpf(cliente.getCnpjCpf());
        super.setData(cliente.getData());
        setEmail(cliente.getEmail());
        super.setNome(cliente.getNome());
        super.setSenha(Criptografia.argon(cliente.getSenha()));
        setListaEndereco(cliente.getListaEndereco());
        setListaTelefone(cliente.getListaTelefone());
    }

    public Cliente() {

    }

    @Override
    public String toString() {
        return "\n\n--Cliente--\nID: " + getId() + "\nNome: " + getNome() + "\nCNPJ/CPF: " + getCnpjCpf() + "\nData: "
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

    // Getters and Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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