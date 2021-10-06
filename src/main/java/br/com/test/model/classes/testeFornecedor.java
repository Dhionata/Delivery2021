package br.com.test.model.classes;

import br.com.model.entities.classes.Fornecedor;

public class testeFornecedor {
    public static void main(String[] args) {
        System.out.println(novoFornecedor().toString());
    }

    public static Fornecedor novoFornecedor() {
        Fornecedor fornecedor = new Fornecedor("TesteLTDA", "Empresa de teste", "000.000.000-00");

        testeEndereco.novaListaEnderecoFornecedor(fornecedor);

        fornecedor.setListaProdutos(testeProdutoFornecedor.novaListaProdutosFornecedor(fornecedor));

        fornecedor.setListaTelefones(testeTelefone.novaListaTelefoneFornecedor(fornecedor));
        return fornecedor;
    }
}