package br.com.model.entities.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.newObjects.model.entities.classes.NovaAvaliacao;
import br.com.newObjects.model.entities.classes.NovoPedido;
import br.com.repository.AvaliacaoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class NovaAvaliacaoTest {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Test
    void testNovaAvaliacao() {
        var a = NovoPedido.novoPedido();
        NovaAvaliacao.novaAvaliacao(a);
        avaliacaoRepository.save(a.getAvaliacao());
        assertEquals(a.getAvaliacao(), avaliacaoRepository.findById(a.getAvaliacao().getId()).get());
    }
}
