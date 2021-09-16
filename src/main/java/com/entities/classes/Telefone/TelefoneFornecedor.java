package com.entities.classes.Telefone;

import com.entities.classes.Fornecedor;

public class TelefoneFornecedor extends Telefone {

    Fornecedor fornecedor;

    public TelefoneFornecedor(Fornecedor fornecedor, String numero) {
        super(numero);
        setFornecedor(fornecedor);
        fornecedor.adicionarTelefone(this);
    }

    @Override
    public String toString() {
        return "\n-- Telefone do fornecedor --\nNúmero: " + super.getNumero() + "\nID: " + super.getId()
                + "\nID do fornecedor: " + getFornecedor();
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

}
