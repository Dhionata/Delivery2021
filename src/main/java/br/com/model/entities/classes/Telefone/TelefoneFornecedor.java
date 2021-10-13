package br.com.model.entities.classes.Telefone;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.model.entities.classes.Usuario.Fornecedor;

@Entity
@PrimaryKeyJoinColumn(name = "id_telefone")
public class TelefoneFornecedor extends Telefone {

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    @JsonIgnore
    private Fornecedor fornecedor;

    public TelefoneFornecedor(Fornecedor fornecedor, String numero) {
        super(numero);
        setFornecedor(fornecedor);
        getFornecedor().adicionarTelefone(this);
    }

    public TelefoneFornecedor() {
    }

    @Override
    public String toString() {
        return "\n\n-- Telefone do fornecedor --\nNúmero: " + super.getNumero() + "\nID: " + super.getId()
                + "\nID do fornecedor: " + getFornecedor().getId();
    }

    // Getters / Setters

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    
}