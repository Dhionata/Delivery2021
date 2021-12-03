package br.com.model.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.model.entities.interfaces.AvaliacaoInterface;

@Entity
public class Avaliacao implements AvaliacaoInterface {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer nota;

    @OneToOne
    @JoinColumn(name = "id_item_pedido")
    @JsonIgnore
    private ItemPedido itemPedido;

    private String comentario;

    public Avaliacao(Integer nota, ItemPedido itemPedido,
            String comentario) {
        setNota(nota);
        setItemPedido(itemPedido);
        setComentario(comentario);
        getItemPedido().setAvaliacao(this);
    }

    public Avaliacao() {

    }

    @Override
    public String toString() {
        return "\n\n-- Avaliacao --\nID: " + getId() + "\nComentário: " + getComentario() + "\nNota: " + getNota()
                + "\nID do Pedido: " + getItemPedido().getId();
    }

    // Getters / Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}