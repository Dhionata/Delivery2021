package br.com.test.model.classes;

import br.com.model.entities.classes.FormaPagamento;

public class testeFormaPagamento {
    public static void main(String[] args) {
        System.out.println(novaFormaPagamento().toString());
    }

    public static FormaPagamento novaFormaPagamento() {
        return new FormaPagamento("Debito");
    }
}
