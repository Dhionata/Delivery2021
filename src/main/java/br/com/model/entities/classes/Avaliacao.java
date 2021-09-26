package br.com.model.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.model.entities.interfaces.AvaliacaoInterface;
import lombok.Data;

@Entity
@Data
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
}