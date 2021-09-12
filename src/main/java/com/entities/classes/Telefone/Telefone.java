package com.entities.classes.Telefone;

public class Telefone {

    private int id;
    private String numero;

    public Telefone(int id, String numero) {
        setId(id);
        setNumero(numero);
    }

    @Override
    public String toString() {
        return "\n-- Telefone --\nID: " + getId() + "\nNúmero: " + getNumero();
    }

    // Getters/Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
