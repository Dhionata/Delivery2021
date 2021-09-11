package com.entities.classes.Telefone;

import com.entities.classes.Fornecedor;

public class TelefoneFornecedor extends Telefone {

    Fornecedor fornecedor;

    public TelefoneFornecedor() {
        super();
        setFornecedor(fornecedor);
    }

    @Override
    public String toString() {
        return "-- Telefone do fornecedor\nFornecedor: " + fornecedor + "Número: " + super.getNumero() + "\nID: "
                + super.getId();
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

}
