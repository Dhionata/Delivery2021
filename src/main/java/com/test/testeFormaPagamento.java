package com.test;

import com.entities.classes.FormaPagamento;

public class testeFormaPagamento {
    public static void main(String[] args) {

        /*
         * public FormaPagamento(int id, String nomeForma, Pedido pedido) { setId(id);
         * setNomeForma(nomeForma); setPedido(pedido); }
         */

        FormaPagamento formaPagamento = new FormaPagamento("Debito");
        System.out.println(formaPagamento.toString());
    }
}
