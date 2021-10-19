package br.com.model.classes;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.classes.NovoCliente;
import br.com.newObjects.model.classes.NovoFornecedor;
import br.com.newObjects.model.classes.NovoTelefone;

public class NovoTelefoneTest {
    @Test
    void testNovaListaTelefoneCliente() {
        // cliente
        System.out.println(NovoTelefone.novaListaTelefoneCliente(NovoCliente.novoCliente()).toString());

    }

    @Test
    void testNovaListaTelefoneFornecedor() {
        // fornecedor

        System.out.println(NovoTelefone.novaListaTelefoneFornecedor(NovoFornecedor.novoFornecedor()));
    }
}
