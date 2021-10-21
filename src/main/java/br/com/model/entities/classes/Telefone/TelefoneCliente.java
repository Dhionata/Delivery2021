package br.com.model.entities.classes.telefone;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.com.model.entities.classes.usuario.Cliente;

@Entity
@PrimaryKeyJoinColumn(name = "id_telefone")
public class TelefoneCliente extends Telefone {

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Cliente cliente;

    public TelefoneCliente(Cliente cliente, String numero) {
        super(numero);
        setCliente(cliente);
        getCliente().adicionarTelefone(this);
    }

    public TelefoneCliente() {
    }

    @Override
    public String toString() {
        return "\n\n-- Telefone do cliente--\nNúmero: " + super.getNumero() + "\nID: " + super.getId()
                + "\nID do cliente: " + getCliente().getId();
    }

    // Getters / Setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}