package br.com.entities.classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;

import br.com.entities.interfaces.ProdutoInterface;

@Entity
public class Produto implements ProdutoInterface {
    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "produto")
    private List<ProdutoFornecedor> listaFornecedores;
    
    private boolean disponivel;

    public Produto(String nome) {
        setNome(nome);
        setDisponivel(true);
        setListaFornecedores(new ArrayList<ProdutoFornecedor>());
    }

    @Override
    public String toString() {
        return "\n--Produto--\nID: " + getId() + "\nNome: " + getNome() + "\nLista de Fornecedores: "
                + getListaFornecedores().toString() + "\nDisponibilidade: " + getDisponivel();
    }

    /*
     * public void adicionarProduto(ProdutoFornecedor produtoFornecedor) {
     * produtoFornecedor.setFornecedor(this);
     * getListaProdutos().add(produtoFornecedor); }
     */

    public void adicionarFornecedor(ProdutoFornecedor produtoFornecedor) {
        produtoFornecedor.setProduto(this);
        getListaFornecedores().add(produtoFornecedor);
    }

    // Getters/Setters

    public Integer getId() {
        return id;
    }

    public List<ProdutoFornecedor> getListaFornecedores() {
        return listaFornecedores;
    }

    public void setListaFornecedores(List<ProdutoFornecedor> listaFornecedores) {
        this.listaFornecedores = listaFornecedores;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
