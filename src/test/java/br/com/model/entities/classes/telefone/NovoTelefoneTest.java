package br.com.model.entities.classes.telefone;

import org.junit.jupiter.api.Test;

import br.com.newObjects.model.entities.classes.telefone.NovoTelefone;
import br.com.newObjects.model.entities.classes.usuario.NovoCliente;
import br.com.newObjects.model.entities.classes.usuario.NovoFornecedor;

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
