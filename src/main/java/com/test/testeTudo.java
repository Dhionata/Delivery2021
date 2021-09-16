package com.test;

import com.entities.classes.*;
import com.entities.classes.Endereco.*;
import com.entities.classes.Telefone.*;

public class testeTudo {
    public static void main(String[] args) {
        // cliente
        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");
        EnderecoCliente enderecoCliente = new EnderecoCliente(cliente, "logradouro", "cidade", "bairro", "complemento",
                "cep", "numero", 0f, 0f);

        // fornecedor
        Fornecedor fornecedor = new Fornecedor("TesteLTDA", "Empresa de teste", "000.000.000-00");
        EnderecoFornecedor enderecoFornecedor = new EnderecoFornecedor(fornecedor, "Anhanguera", "Goiânia", "Cerrado",
                "Q.0, L.0", "0000000-00", "S/N", 0.000000F, 0.000000F);

        // telefones
        TelefoneCliente telefoneDoCliente = new TelefoneCliente(cliente, "(xx)yrrrr-rrrr");
        TelefoneCliente telefoneDoCliente2 = new TelefoneCliente(cliente, "(xx)ydddd-dddd");

        TelefoneFornecedor telefoneFornecedor = new TelefoneFornecedor(fornecedor, "(ii)thhhh-hhhh");
        TelefoneFornecedor telefoneDoFornecedor = new TelefoneFornecedor(fornecedor, "(yy)qaaaa-zzzz");

        Produto produto = new Produto("Abacate");
        Produto produto2 = new Produto("Laranja");

        // ligação entre Fornecedor e Produto é FornecedorProduto
        ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor(produto, fornecedor, 0.15f, 3);
        ProdutoFornecedor produtoFornecedor2 = new ProdutoFornecedor(produto2, fornecedor, 8.76f, 7);

        // forma de pagamento
        FormaPagamento formaPagamento = new FormaPagamento("Débito");

        // pedido
        Pedido pedido = new Pedido(cliente, formaPagamento, 7.00f, false, false);

        ItemPedido itemPedido = new ItemPedido(pedido, produto, 5);
        ItemPedido itemPedido2 = new ItemPedido(pedido, produto2, 6);

        Avaliacao avaliacao = new Avaliacao(5, pedido, "teste de comentário");

        System.out.println(pedido.toString());
    }
}
