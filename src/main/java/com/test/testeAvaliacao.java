package com.test;

import com.entities.classes.Avaliacao;
import com.entities.classes.Cliente;
import com.entities.classes.FormaPagamento;
import com.entities.classes.Pedido;

public class testeAvaliacao {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");
        FormaPagamento formaPagamento = new FormaPagamento("Débito");
        Pedido pedido = new Pedido(cliente, formaPagamento, 7.00f, false, false);

        Avaliacao avaliacao = new Avaliacao(5, pedido, "teste de comentário");

        System.out.println(avaliacao.toString());
        System.out.println(pedido.toString());
    }
}
