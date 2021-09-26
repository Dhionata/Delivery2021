package br.com.model.entities.interfaces;

public interface PedidoInterface {
    public Float calculaValorTotal();
    public boolean statusEntrega(int idPedido);
}
