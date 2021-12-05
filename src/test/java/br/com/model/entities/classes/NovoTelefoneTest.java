package br.com.model.entities.classes;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.entities.classes.NovoTelefone;
import br.com.newObjects.model.entities.classes.usuario.NovoFornecedor;

public class NovoTelefoneTest {

    @Test
    void testNovaListaTelefone() {
        System.out.println(NovoTelefone.novaListaTelefones(NovoFornecedor.novoFornecedor()));
    }
}
