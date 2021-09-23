package br.com.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.entities.interfaces.AvaliacaoInterface;

@Entity
public class Avaliacao implements AvaliacaoInterface {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer nota;

    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    private String comentario;

    public Avaliacao(Integer nota, Pedido pedido, String comentario) {
        setNota(nota);
        setPedido(pedido);
        setComentario(comentario);
        getPedido().setAvaliacao(this);
    }

    public Avaliacao() {

    }

    @Override
    public String toString() {
        return "\n-- Avaliacao --\nID: " + getId() + "\nComentário: " + getComentario() + "\nNota: " + getNota()
                + "\nID do Pedido: " + getPedido().getId();
    }

    // Getters/Setters

    public int getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}