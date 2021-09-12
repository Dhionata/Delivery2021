package com.test;

import java.util.ArrayList;
import java.util.List;

import com.entities.classes.Endereco;
import com.entities.classes.Fornecedor;
import com.entities.classes.Produto;

public class testeFornecedor {
    public static void main(String[] args) {

        Fornecedor fornecedor = new Fornecedor(1, "TesteLTDA", "Empresa de teste", new Endereco(2, "Anhanguera",
                "Goiânia", "Cerrado", "Q.0, L.0", "0000000-00", "S/N", 0.000000F, 0.000000F), "000.000.000-00");

        List<Produto> produtos = new ArrayList<Produto>();

        for (int i = 0; i <= 10; i++) {
            Produto p = new Produto(i, "NomeAleatório>" + Math.pow(i, 3), fornecedor, 0.42F * i, 100 * i);
            produtos.add(p);
        }

        fornecedor.setListaProdutos(produtos);
        System.out.println(fornecedor.toString());
    }
}
// public Produto(int id, String nome, Fornecedor idFornecedor, Float preco,
// Boolean disponivel, int quantidadeEmEstoque)