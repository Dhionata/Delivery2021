package br.com.model.entities.classes;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class NovaFormaPagamentoTest {

    @Test
    @RepeatedTest(5)
    void novaFormaPagamento() {
        System.out.println(FormaPagamento.novaFormaPagamento(new Random().nextInt(5) + 1));
    }
}
