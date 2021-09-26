package br.com.model.entities.classes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.model.entities.interfaces.ProdutoFornecedorInterface;
import lombok.Data;

@Entity
@Data
public class ProdutoFornecedor implements ProdutoFornecedorInterface {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
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
        return "\n-- ProdutoFornecedor --\nID: " + getId() + "\nData de atualização: " + getDataAtualizacao()
                + "\nData de cadastro: " + getDataCadastro() + "\nFornecedor: " + getFornecedor().getNome()
                + "\nProduto: " + getProduto().getNome() + "\nQuantidade em estoque: " + getQuantidadeEmEstoque()
                + "\nPreço: " + getPreco();
    }

    @Override
    public Produto buscarProduto(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    public void setId(Integer id) {
        this.id = id;
        setDataAtualizacao(new Date());
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        setDataAtualizacao(new Date());
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
        setDataAtualizacao(new Date());
    }

    public void setPreco(Float preco) {
        this.preco = preco;
        setDataAtualizacao(new Date());
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        setDataAtualizacao(new Date());
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
        setDataAtualizacao(new Date());
    }
}