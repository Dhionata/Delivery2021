package br.com.model.entities.classes.Telefone;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.com.model.entities.classes.Cliente;
import lombok.Data;

@Entity
@PrimaryKeyJoinColumn(name = "id_telefone")
@Data
public class TelefoneCliente extends Telefone {

    @ManyToOne
    @JoinColumn(name = "id_cliente")
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
        return "\n-- Telefone do cliente--\nNúmero: " + super.getNumero() + "\nID: " + super.getId()
                + "\nID do cliente: " + getCliente().getId();
    }
}