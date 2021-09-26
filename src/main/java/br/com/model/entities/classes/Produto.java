package br.com.model.entities.classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.model.entities.interfaces.ProdutoInterface;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
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

    public Produto() {
    }

    @Override
    public String toString() {
        return "\n--Produto--\nID: " + getId() + "\nNome: " + getNome() + "\nLista de Fornecedores: "
                + getListaFornecedores().toString() + "\nDisponibilidade: " + isDisponivel();
    }

    public void adicionarFornecedor(ProdutoFornecedor produtoFornecedor) {
        produtoFornecedor.setProduto(this);
        getListaFornecedores().add(produtoFornecedor);
    }
}