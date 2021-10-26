package br.com.model.entities.interfaces;

import br.com.model.entities.classes.Pedido;
public interface PedidoInterface {
    public Float calculaValorTotal(Pedido pedido);
}