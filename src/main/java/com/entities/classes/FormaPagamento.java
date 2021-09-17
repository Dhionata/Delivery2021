package com.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.entities.interfaces.FormaPagamentoInterface;

@Entity
public class FormaPagamento implements FormaPagamentoInterface {
    @Id
    @GeneratedValue
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
