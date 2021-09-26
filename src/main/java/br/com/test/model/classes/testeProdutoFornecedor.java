package br.com.test.model.classes;

import br.com.model.entities.classes.Fornecedor;
import br.com.model.entities.classes.Produto;
import br.com.model.entities.classes.ProdutoFornecedor;
import br.com.model.entities.classes.Endereco.EnderecoFornecedor;

public class testeProdutoFornecedor {
    public static void main(String[] args) {
        // public ProdutoFornecedor(Produto produto, Fornecedor fornecedor, Float preco,
        // int quantidadeEmEstoque)
        Produto produto = new Produto("Abacate");
        Produto produto2 = new Produto("Laranja");
        Fornecedor fornecedor = new Fornecedor("TesteLTDA", "Empresa de teste", "000.000.000-00");

        EnderecoFornecedor enderecoFornecedor = new EnderecoFornecedor(fornecedor, "Anhanguera", "Goiânia", "Cerrado",
                "Q.0, L.0", "0000000-00", "S/N", 0.000000F, 0.000000F);

        ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor(produto, fornecedor, 0.15f, 3);
        ProdutoFornecedor produtoFornecedor2 = new ProdutoFornecedor(produto2, fornecedor, 0.45f, 5);

        System.out.println(produtoFornecedor.toString());
        System.out.println(produtoFornecedor2.toString());
    }
}
