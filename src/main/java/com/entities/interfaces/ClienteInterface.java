package com.entities.interfaces;

import java.util.List;

import com.entities.classes.Endereco;
import com.entities.classes.Pedido;

public interface ClienteInterface {
    public void cadastrarEndereco(Endereco endereco);
    public void removeEndereco(Endereco endereco);
    public boolean realizarPagamento(Float valor);
    public void listaPedido(List<Pedido> pedidos);
}