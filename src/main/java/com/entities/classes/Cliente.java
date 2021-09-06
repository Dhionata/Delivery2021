package com.entities.classes;

import java.util.List;

import com.entities.interfaces.ClienteInterface;

public class Cliente implements ClienteInterface{

    @Override
    public void cadastrarEndereco(Endereco endereco) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeEndereco(Endereco endereco) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean realizarPagamento(Float valor) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void listaPedido(List<Pedido> pedidos) {
        // TODO Auto-generated method stub
        
    }

}