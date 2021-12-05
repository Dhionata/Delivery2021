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
    @JoinColumn(name = "id_pedido")
    @JsonIgnore
    private Pedido pedido;

    private String comentario;

    public Avaliacao(Integer nota, Pedido pedido,
            String comentario) {
        setNota(nota);
        setPedido(pedido);
        setComentario(comentario);
        getPedido().setAvaliacao(this);
    }

    public Avaliacao() {

    }

    @Override
    public String toString() {
        return "\n\n-- Avaliacao --\nID: " + getId() + "\nComentário: " + getComentario() + "\nNota: " + getNota()
                + "\nID do Pedido: " + getPedido().getId();
    }

    // Getters / Setters

    public Integer getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}