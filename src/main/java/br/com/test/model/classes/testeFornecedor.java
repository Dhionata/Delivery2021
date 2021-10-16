package br.com.test.model.classes;

import br.com.model.entities.classes.Usuario.Fornecedor;

public class TesteFornecedor {
    public static void main(String[] args) {
        System.out.println(novoFornecedor().toString());
    }

    public static Fornecedor novoFornecedor() {
        Fornecedor fornecedor = new Fornecedor("TesteLTDA", "Empresa de teste", "000.000.000-00", "senhaTeste",
                "email@teste.com.br");

        TesteEndereco.novaListaEnderecoFornecedor(fornecedor);

        fornecedor.setListaProdutoFornecedor(TesteProdutoFornecedor.novaListaProdutosFornecedor(fornecedor));

        fornecedor.setListaTelefones(TesteTelefone.novaListaTelefoneFornecedor(fornecedor));
        return fornecedor;
    }
}