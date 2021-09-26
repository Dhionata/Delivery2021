package br.com.model.entities.classes.Telefone;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.com.model.entities.classes.Fornecedor;
import lombok.Data;

@Entity
@PrimaryKeyJoinColumn(name = "id_telefone")
@Data
public class TelefoneFornecedor extends Telefone {

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
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
        return "\n-- Telefone do fornecedor --\nNúmero: " + super.getNumero() + "\nID: " + super.getId()
                + "\nID do fornecedor: " + getFornecedor().getId();
    }
}