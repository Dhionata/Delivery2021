package com.entities.classes.Telefone;

import com.entities.classes.Cliente;

public class TelefoneCliente extends Telefone {

    Cliente cliente;

    public TelefoneCliente(Cliente cliente, String numero) {
        super(numero);
        setCliente(cliente);
    }

    @Override
    public String toString() {
        return "\n-- Telefone do cliente--\nNúmero: " + super.getNumero() + "\nID: " + super.getId()
                + "\nID do cliente: " + getCliente();
    }

    // Getters/Setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
