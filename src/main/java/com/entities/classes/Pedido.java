package com.entities.classes;

import java.util.Date;

import com.entities.interfaces.PedidoInterface;

public class Pedido implements PedidoInterface {

    private int id;
    private Cliente cliente;
    private FormaPagamento formaPagamento;
    private ItemPedido itemPedido;
    private Float desconto;
    private Boolean pago;
    private Boolean entregue;
    private Date data;

    public Pedido(int id, Cliente cliente, FormaPagamento formaPagamento, ItemPedido itemPedido, Float desconto,
            Boolean pago, Boolean entregue) {
        setId(id);
        setCliente(cliente);
        setFormaPagamento(formaPagamento);
        setItemPedido(itemPedido);
        setDesconto(desconto);
        setPago(pago);
        setEntregue(entregue);
        setData(new Date());
    }

    @Override
    public String toString() {
        return "\n-- Pedido -- \nCliente: " + cliente + "\nData: " + data + "\nDesconto: " + desconto + "\nEntregue: "
                + entregue + "\nForma de pagamento: " + formaPagamento + "\nID: " + id + "\nItem pedido: " + itemPedido
                + "\nPago: " + pago;
    }

    @Override
    public Float calculaValorTotal() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean statusEntrega(int idPedido) {
        // TODO Auto-generated method stub
        return false;
    }

    // Getters/Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(Boolean entregue) {
        this.entregue = entregue;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
