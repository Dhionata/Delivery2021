package br.com.test.classes;

import br.com.entities.classes.FormaPagamento;

public class testeFormaPagamento {
    public static void main(String[] args) {
        FormaPagamento formaPagamento = new FormaPagamento("Debito");
        System.out.println(formaPagamento.toString());
    }
}
