package com.entities.classes.Telefone;

import com.entities.classes.Fornecedor;

public class TelefoneFornecedor extends Telefone {

    Fornecedor fornecedor;

    public TelefoneFornecedor(Fornecedor fornecedor, int id, String numero) {
        super(id, numero);
        setFornecedor(fornecedor);
    }

    @Override
    public String toString() {
        return "\n-- Telefone do fornecedor --\nNúmero: " + super.getNumero() + "\nID: " + super.getId();
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

}
