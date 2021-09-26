package br.com.model.entities.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.model.entities.classes.Endereco.EnderecoCliente;
import br.com.model.entities.classes.Telefone.TelefoneCliente;
import br.com.model.entities.interfaces.ClienteInterface;
import lombok.Data;

@Entity
@Data
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

    public Cliente() {

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
}