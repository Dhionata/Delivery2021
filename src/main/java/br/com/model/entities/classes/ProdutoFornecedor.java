package br.com.model.entities.classes;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.model.entities.classes.usuario.Fornecedor;
import br.com.model.entities.interfaces.ProdutoFornecedorInterface;

@Entity
public class ProdutoFornecedor implements ProdutoFornecedorInterface {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produto")
    @JsonIgnore
    private Produto produto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Fornecedor fornecedor;

    private Float preco;
    private Integer quantidadeEmEstoque;
    private Date dataCadastro;
    private Date dataAtualizacao;

    public ProdutoFornecedor(Produto produto, Fornecedor fornecedor, Float preco, Integer quantidadeEmEstoque) {
        setProduto(produto);
        setFornecedor(fornecedor);
        setPreco(preco);
        setQuantidadeEmEstoque(quantidadeEmEstoque);
        setDataCadastro(new Date());
        getFornecedor().adicionarProduto(this);
        getProduto().adicionarFornecedor(this);
    }

    public ProdutoFornecedor() {

    }

    @Override
    public String toString() {
        return "\n\n-- ProdutoFornecedor --\nID: " + getId() + "\nData de atualização: " + getDataAtualizacao()
                + "\nData de cadastro: " + getDataCadastro() + "\nFornecedor: " + getFornecedor().getNome()
                + "\nProduto: " + getProduto().getNome() + "\nQuantidade em estoque: " + getQuantidadeEmEstoque()
                + "\nPreço: " + getPreco();
    }

    // Getters / Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        setDataAtualizacao(new Date());
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        setDataAtualizacao(new Date());
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
        setDataAtualizacao(new Date());
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
        setDataAtualizacao(new Date());
    }

    public Integer getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        setDataAtualizacao(new Date());
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
        setDataAtualizacao(new Date());
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

}