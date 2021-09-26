package br.com.test.model.classes;

import br.com.model.entities.classes.FormaPagamento;

public class testeFormaPagamento {
    public static void main(String[] args) {
        FormaPagamento formaPagamento = new FormaPagamento("Debito");
        System.out.println(formaPagamento.toString());
    }
}
