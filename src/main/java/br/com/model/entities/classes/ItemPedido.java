package br.com.model.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.model.entities.interfaces.ItemPedidoInterface;

@Entity
public class ItemPedido implements ItemPedidoInterface {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    private Integer quantidade;

    @OneToOne(mappedBy = "itemPedido")
    @JsonIgnore
    private Avaliacao avaliacao;

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
        setPedido(pedido);
        setProduto(produto);
        setQuantidade(quantidade);
        getPedido().getItensPedido().add(this);
    }

    public ItemPedido() {

    }

    @Override
    public String toString() {
        return "\n-- ItemPedido --\nID: " + getId() + "\nPedido: " + getPedido().getId() + getProduto()
                + "\nQuantidade pedida: " + getQuantidade();
    }

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

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    
}