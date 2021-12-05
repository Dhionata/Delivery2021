package br.com.newObjects.model.entities.classes.usuario;

import br.com.model.entities.classes.usuario.Fornecedor;
import br.com.newObjects.model.entities.classes.NovoEndereco;
import br.com.newObjects.model.entities.classes.NovoTelefone;

public class NovoFornecedor {

    public static Fornecedor novoFornecedor() {
        Fornecedor fornecedor = new Fornecedor("TesteLTDA",
                "Empresa de teste", "000.000.000-00",
                "senhaTeste",
                "email@testeFornecedor.com.br");

        NovoEndereco.novaListaEndereco(fornecedor);

        fornecedor.setTelefones(NovoTelefone.novaListaTelefones(fornecedor));
        return fornecedor;
    }
}