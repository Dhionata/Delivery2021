package br.com.model.entities.classes

import br.com.model.entities.classes.FormaPagamento.Companion.novaFormaPagamento
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import java.util.*

class NovaFormaPagamentoTest {
    @Test
    @RepeatedTest(5)
    fun novaFormaPagamento() {
        println(novaFormaPagamento(Random().nextInt(5) + 1))
    }
}