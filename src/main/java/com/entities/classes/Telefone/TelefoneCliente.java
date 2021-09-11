package com.entities.classes.Telefone;

import com.entities.classes.Cliente;

public class TelefoneCliente extends Telefone {

    Cliente cliente;

    public TelefoneCliente(Cliente cliente) {
        super();
        setCliente(cliente);
    }

    @Override
    public String toString() {
        return "-- Telefone do cliente\nCliente: " + cliente + "Número: " + super.getNumero() + "\nID: "
                + super.getId();
    }

    // Getters/Setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
