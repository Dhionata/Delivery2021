package com.entities.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entities.interfaces.PedidoInterface;

public class Pedido implements PedidoInterface {

    private int id;
    private Cliente cliente;
    private FormaPagamento formaPagamento;
    private List<ItemPedido> itensPedido;
    private Float desconto;

    private Boolean pago;
    private Boolean entregue;
    private Date data;

    public Pedido(int id, Cliente cliente, FormaPagamento formaPagamento, Float desconto, Boolean pago,
            Boolean entregue) {
        setId(id);
        setCliente(cliente);
        setFormaPagamento(formaPagamento);
        setDesconto(desconto);
        setPago(pago);
        setEntregue(entregue);
        setItensPedido(new ArrayList<>());
        setData(new Date());
    }

    @Override
    public String toString() {
        return "\n-- Pedido -- \nID: " + getId() + getCliente() + "\nData: " + getData() + "\nDesconto: "
                + getDesconto() + "\nEntregue: " + getEntregue() + getItensPedido() + getFormaPagamento() + "\nPago: "
                + getPago();
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

    public void addItemPedido(ItemPedido itemPedido) {
        getItensPedido().add(itemPedido);
    }

    public void removerItemPedido(ItemPedido itemPedido) {
        getItensPedido().remove(itemPedido);
    }

    // Getters/Setters

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

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
