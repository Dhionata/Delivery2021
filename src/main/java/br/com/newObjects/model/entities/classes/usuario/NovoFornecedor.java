package br.com.newObjects.model.entities.classes.usuario;

import br.com.model.entities.classes.usuario.Fornecedor;
import br.com.newObjects.model.entities.classes.endereco.NovoEndereco;
import br.com.newObjects.model.entities.classes.telefone.NovoTelefone;

public class NovoFornecedor {

    public static Fornecedor novoFornecedor() {
        Fornecedor fornecedor = new Fornecedor("TesteLTDA", "Empresa de teste", "000.000.000-00", "senhaTeste",
                "email@testeFornecedor.com.br");

        NovoEndereco.novaListaEnderecoFornecedor(fornecedor);

        fornecedor.setListaTelefones(NovoTelefone.novaListaTelefoneFornecedor(fornecedor));
        return fornecedor;
    }
}