package com.test;

import com.entities.classes.Fornecedor;
import com.entities.classes.Produto;
import com.entities.classes.ProdutoFornecedor;
import com.entities.classes.Endereco.EnderecoFornecedor;

public class testeFornecedor {
    public static void main(String[] args) {

        Fornecedor fornecedor = new Fornecedor("TesteLTDA", "Empresa de teste", "000.000.000-00");

        EnderecoFornecedor enderecoFornecedor = new EnderecoFornecedor(fornecedor, "Anhanguera", "Goiânia", "Cerrado",
                "Q.0, L.0", "0000000-00", "S/N", 0.000000F, 0.000000F);

        fornecedor.adicionarProduto(new ProdutoFornecedor(new Produto("Mamão"), fornecedor, 0.15f, 3));
        fornecedor.setEndereco(enderecoFornecedor);
        System.out.println(fornecedor.toString());
    }
}