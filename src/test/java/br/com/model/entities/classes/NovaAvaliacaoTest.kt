package br.com.model.entities.classes

import br.com.newObjects.model.entities.classes.NovaAvaliacao
import br.com.newObjects.model.entities.classes.NovoPedido
import br.com.repository.AvaliacaoRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class NovaAvaliacaoTest(@Autowired private val avaliacaoRepository: AvaliacaoRepository) {
    @Test
    fun testNovaAvaliacao() {
        val a = NovoPedido.novoPedido()
        NovaAvaliacao.novaAvaliacao(a)
        avaliacaoRepository.save(a.avaliacao!!)
        Assertions.assertEquals(a.avaliacao, avaliacaoRepository.findById(a.avaliacao?.id!!).get())
    }
}
