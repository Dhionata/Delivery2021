package com.entities.classes;

import com.entities.interfaces.AvaliacaoInterface;

public class Avaliacao implements AvaliacaoInterface {
    private int id;
    private int nota;
    private Pedido pedido;
    private String comentario;

    public Avaliacao(int nota, Pedido pedido, String comentario) {
        setNota(nota);
        setPedido(pedido);
        setComentario(comentario);
    }

    @Override
    public String toString() {
        return "\n--Avaliacao--\nID: " + getId() + "\nComentário: " + getComentario() + "\nNota: " + getNota()
                + "\nPedido: " + getPedido();
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