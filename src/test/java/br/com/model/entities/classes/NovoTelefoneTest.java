package br.com.model.entities.classes;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.entities.classes.usuario.NovoFornecedor;

public class NovoTelefoneTest {

    @Test
    void testNovaListaTelefone() {
        var fornecedor = NovoFornecedor.novoFornecedor();
        System.out.println(fornecedor.getTelefones());
    }
}
