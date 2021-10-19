package br.com.model.classes;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import br.com.model.entities.classes.FormaPagamento;

public class NovaFormaPagamento {

    @Test
    @RepeatedTest(5)
    void novaFormaPagamento() {
        System.out.println(FormaPagamento.novaFormaPagamento(new Random().nextInt(5) + 1));
    }
}
