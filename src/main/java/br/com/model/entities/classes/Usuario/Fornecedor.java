package br.com.model.entities.classes.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.model.entities.classes.ProdutoFornecedor;
import br.com.model.entities.classes.Endereco.EnderecoFornecedor;
import br.com.model.entities.classes.Telefone.TelefoneFornecedor;
import br.com.model.entities.interfaces.FornecedorInterface;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Fornecedor extends Usuario implements FornecedorInterface {
    private String descricao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco_fornecedor")
    private EnderecoFornecedor endereco;

    @OneToMany(mappedBy = "fornecedor")
    @JsonIgnore
    private List<ProdutoFornecedor> listaProdutos;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<TelefoneFornecedor> listaTelefones;

    public Fornecedor(String nome, String descricao, String cnpjCpf) {
        super.setNome(nome);
        setDescricao(descricao);
        setEndereco(endereco);
        super.setCnpjCpf(cnpjCpf);
        super.setData(new Date());
        setListaProdutoFornecedor(new ArrayList<ProdutoFornecedor>());
        setListaTelefones(new ArrayList<TelefoneFornecedor>());
    }

    public Fornecedor() {

    }

    @Override
    public String toString() {
        return "\n\n--Fornecedor--\nNome: " + getNome() + "\nID: " + getId() + "\nCNPJ/CPF: " + getCnpjCpf()
                + "\nData: " + getData() + "\nDescriçao: " + getDescricao() + getEndereco() + getListaTelefones();
    }

    @Override
    public void adicionarProduto(ProdutoFornecedor produtoFornecedor) {
        produtoFornecedor.setFornecedor(this);
        getListaProdutoFornecedor().add(produtoFornecedor);
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

    // Getters / Setters

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

    public List<ProdutoFornecedor> getListaProdutoFornecedor() {
        return listaProdutos;
    }

    public void setListaProdutoFornecedor(List<ProdutoFornecedor> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public List<TelefoneFornecedor> getListaTelefones() {
        return listaTelefones;
    }

    public void setListaTelefones(List<TelefoneFornecedor> listaTelefones) {
        this.listaTelefones = listaTelefones;
    }

}