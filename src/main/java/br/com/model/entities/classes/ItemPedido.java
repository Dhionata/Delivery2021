package br.com.model.entities.classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne()
    // @JsonIgnore
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produto")
    private Produto produto;

    private Integer quantidade;

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
        setPedido(pedido);
        setProduto(produto);
        setQuantidade(quantidade);
        getPedido().getItensPedido().add(this);
    }

    public ItemPedido(Produto produto, Integer quantidade) {
        setProduto(produto);
        setQuantidade(quantidade);
    }

    public ItemPedido() {

    }

    @Override
    public String toString() {
        return "\n\n-- ItemPedido --\nID: " + getId() + "\nPedido: " + getPedido().getId() + getProduto()
                + "\nQuantidade pedida: " + getQuantidade();
    }

    // Getters / Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}