package com.entities.classes;
import java.util.Date;

import com.entities.interfaces.PedidoInterface;

public class Pedido implements PedidoInterface{

    int id;
    Cliente cliente;
    FormaPagamento formaPagamento;
    ItemPedido itemPedido;
    Float desconto;
    Float acrescimo;
    Boolean pago;
    Boolean entregue;
    Date data;


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
    
}
