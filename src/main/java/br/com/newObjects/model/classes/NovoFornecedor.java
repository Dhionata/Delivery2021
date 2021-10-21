package br.com.newObjects.model.classes;

import br.com.model.entities.classes.Usuario.Fornecedor;

public class NovoFornecedor {

    public static Fornecedor novoFornecedor() {
        Fornecedor fornecedor = new Fornecedor("TesteLTDA", "Empresa de teste", "000.000.000-00", "senhaTeste",
                "email@testeFornecedor.com.br");

        NovoEndereco.novaListaEnderecoFornecedor(fornecedor);

        fornecedor.setListaTelefones(NovoTelefone.novaListaTelefoneFornecedor(fornecedor));
        return fornecedor;
    }
}