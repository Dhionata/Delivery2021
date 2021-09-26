package br.com.model.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.model.entities.interfaces.ItemPedidoInterface;
import lombok.Data;

@Entity
@Data
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
}