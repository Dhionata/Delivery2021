
package com.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.entities.interfaces.ItemPedidoInterface;

@Entity
public class ItemPedido implements ItemPedidoInterface {
    @Id
    @GeneratedValue
    private int id;
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    @JoinColumn(name = "id_produto")
    private Produto produto;
    private int quantidade;

    public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
        setPedido(pedido);
        setProduto(produto);
        setQuantidade(quantidade);
        getPedido().getItensPedido().add(this);
    }

    @Override
    public String toString() {
        return "\n-- ItemPedido --\nID: " + getId() + "\nPedido: " + getPedido().getId() + getProduto()
                + "\nQuantidade pedida: " + getQuantidade();
    }

    // Getters/Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}