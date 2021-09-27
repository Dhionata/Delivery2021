package br.com.model.entities.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.model.entities.interfaces.PedidoInterface;
import lombok.Data;

@Entity
@Data
public class Pedido implements PedidoInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento")
    private FormaPagamento formaPagamento;

    private Float desconto;
    private Boolean pago;
    private Boolean entregue;
    private Date data;

    @OneToOne(mappedBy = "pedido")
    private Avaliacao avaliacao;

    public Pedido(Cliente cliente, FormaPagamento formaPagamento, Float desconto, Boolean pago, Boolean entregue) {
        setCliente(cliente);
        setFormaPagamento(formaPagamento);
        setDesconto(desconto);
        setPago(pago);
        setEntregue(entregue);
        setItensPedido(new ArrayList<>());
        setData(new Date());
    }

    public Pedido() {
    }

    @Override
    public String toString() {
        return "\n-- Pedido -- \nID: " + getId() + "\nData: " + getData() + "\nDesconto: " + getDesconto()
                + "\nEntregue: " + getEntregue() + getItensPedido() + getFormaPagamento() + "\nPago: " + getPago()
                + getCliente(); //getAvaliacao();
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
}