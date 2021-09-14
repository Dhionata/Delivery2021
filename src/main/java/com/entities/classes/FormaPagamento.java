package com.entities.classes;

import com.entities.interfaces.FormaPagamentoInterface;

public class FormaPagamento implements FormaPagamentoInterface {

    private int id;
    private String nomeForma;

    public FormaPagamento(String nomeForma) {
        setNomeForma(nomeForma);
    }

    @Override
    public String toString() {
        return "\n-- FormaPagamento --\nID: " + getId() + "\nNome da forma de pagamento: " + getNomeForma();
    }

    @Override
    public String formaDePagamento() {
        // TODO Auto-generated method stub
        return null;
    }

    // Getters/Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeForma() {
        return nomeForma;
    }

    public void setNomeForma(String nomeForma) {
        this.nomeForma = nomeForma;
    }

}
