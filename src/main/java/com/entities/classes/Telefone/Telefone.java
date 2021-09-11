package com.entities.classes.Telefone;

import com.entities.interfaces.TelefoneInterface;

public class Telefone implements TelefoneInterface {

    private int id;
    private String numero;

    @Override
    public String toString() {
        return "-- Telefone --\nID: " + id + "\nNúmero: " + numero;
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
