package br.com.entities.classes.Telefone;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.com.entities.classes.Fornecedor;

@Entity
@PrimaryKeyJoinColumn(name = "id_telefone")
public class TelefoneFornecedor extends Telefone {

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    public TelefoneFornecedor(Fornecedor fornecedor, String numero) {
        super(numero);
        setFornecedor(fornecedor);
        getFornecedor().adicionarTelefone(this);
    }

    @Override
    public String toString() {
        return "\n-- Telefone do fornecedor --\nNúmero: " + super.getNumero() + "\nID: " + super.getId()
                + "\nID do fornecedor: " + getFornecedor().getId();
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

}