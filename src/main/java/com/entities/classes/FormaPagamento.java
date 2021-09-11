package com.entities.classes;

import com.entities.interfaces.FormaPagamentoInterface;

public class FormaPagamento implements FormaPagamentoInterface {

    private int id;
    private String nomeForma;
    private Pedido pedido;

    public FormaPagamento(int id, String nomeForma, Pedido pedido) {
        setId(id);
        setNomeForma(nomeForma);
        setPedido(pedido);
    }

    @Override
    public String toString() {
        return "\n-- FormaPagamento --\nID: " + id + "\nNome da forma de pagamento: " + nomeForma + "\nPedido: "
                + pedido;
    }

    @Override
    public String formaDePagamento() {
        // TODO Auto-generated method stub
        return null;
    }

    // Getters/Setters

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeForma() {
        return nomeForma;
    }

    public void setNomeForma(String nomeForma) {
        this.nomeForma = nomeForma;
    }

}
