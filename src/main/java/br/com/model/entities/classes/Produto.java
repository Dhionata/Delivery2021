package br.com.model.entities.classes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.model.entities.interfaces.ProdutoInterface;

import java.util.ArrayList;

@Entity
public class Produto implements ProdutoInterface {
    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ProdutoFornecedor> listaFornecedores = new ArrayList<>();

    private boolean disponivel = true;

    public Produto(String nome) {
        setNome(nome);
    }

    public Produto(String nome, List<ProdutoFornecedor> listaProdutoFornecedor) {
        setNome(nome);
        setListaProdutoFornecedores(listaProdutoFornecedor);
    }

    public Produto(String nome, ProdutoFornecedor produtoFornecedor){
        setNome(nome);
        adicionarFornecedor(produtoFornecedor);
    }

    public Produto() {
    }

    @Override
    public String toString() {
        return "\n\n--Produto--\nID: " + getId() + "\nNome: " + getNome() + "\nLista de Fornecedores: "
                + getListaProdutoFornecedores() + "\nDisponibilidade: " + isDisponivel();
    }

    public void adicionarFornecedor(ProdutoFornecedor produtoFornecedor) {
        produtoFornecedor.setProduto(this);
        getListaProdutoFornecedores().add(produtoFornecedor);
    }

    // Getters / Setters

    public Integer getId() {
        return id;
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

    public List<ProdutoFornecedor> getListaProdutoFornecedores() {
        return listaFornecedores
;
    }

    public void setListaProdutoFornecedores(List<ProdutoFornecedor> listaFornecedores) {
        this.listaFornecedores
 = listaFornecedores;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}