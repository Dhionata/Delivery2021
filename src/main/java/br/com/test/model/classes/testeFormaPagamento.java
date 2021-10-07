package br.com.test.model.classes;

import java.util.Random;

import br.com.model.entities.classes.FormaPagamento;

public class testeFormaPagamento {
    public static void main(String[] args) {
        System.out.println(FormaPagamento.novaFormaPagamento(new Random().nextInt(5)).toString());
    }
}
