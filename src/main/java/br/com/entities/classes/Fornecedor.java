package br.com.entities.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.entities.classes.Endereco.EnderecoFornecedor;
import br.com.entities.classes.Telefone.TelefoneFornecedor;
import br.com.entities.interfaces.FornecedorInterface;

@Entity
public class Fornecedor implements FornecedorInterface {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String descricao;

    @OneToOne
    @JoinColumn(name = "id_endereco_fornecedor")
    private EnderecoFornecedor endereco;

    private String cnpjCpf;
    private Date data;

    @OneToMany(mappedBy = "fornecedor")
    private List<ProdutoFornecedor> listaProdutos;

    @OneToMany(mappedBy = "fornecedor")
    private List<TelefoneFornecedor> listaTelefones;

    public Fornecedor(String nome, String descricao, String cnpjCpf) {
        setNome(nome);
        setDescricao(descricao);
        setEndereco(endereco);
        setCnpjCpf(cnpjCpf);
        setData(new Date());
        setListaProdutos(new ArrayList<ProdutoFornecedor>());
        setListaTelefones(new ArrayList<TelefoneFornecedor>());
    }

    public Fornecedor() {

    }

    @Override
    public String toString() {
        return "\n--Fornecedor--\nNome: " + getNome() + "\nCNPJ/CPF: " + getCnpjCpf() + "\nData: " + getData()
                + "\nDescriçao: " + getDescricao() + getEndereco() + "\nID: " + getId() + getListaTelefones()
                + "\nLista de produtos: " + getListaProdutos();
    }

    @Override
    public void adicionarProduto(ProdutoFornecedor produtoFornecedor) {
        produtoFornecedor.setFornecedor(this);
        getListaProdutos().add(produtoFornecedor);
    }

    @Override
    public void adicionarTelefone(TelefoneFornecedor telefone) {
        getListaTelefones().add(telefone);
    }

    @Override
    public boolean confirmarPedido(int idPedido) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeProduto(ProdutoFornecedor produto) {
        // TODO Auto-generated method stub

    }

    @Override
    public void confirmarEntrega(int idPedido) {
        // TODO Auto-generated method stub

    }

    @Override
    public void atualizarStatusPedido(int idPedido) {
        // TODO Auto-generated method stub

    }

    // Verificar a possibilidade de uma lista de fornecedores.
    @Override
    public Fornecedor buscarFornecedor(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean confirmarEstoque(int quantidadeEmEstoque) {
        // TODO Auto-generated method stub
        return false;
    }

    // Getters/Setters

    public List<TelefoneFornecedor> getListaTelefones() {
        return listaTelefones;
    }

    public void setListaTelefones(List<TelefoneFornecedor> telefone) {
        this.listaTelefones = telefone;
    }

    public void setListaProdutos(List<ProdutoFornecedor> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public List<ProdutoFornecedor> getListaProdutos() {
        return listaProdutos;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EnderecoFornecedor getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoFornecedor endereco) {
        this.endereco = endereco;
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

}