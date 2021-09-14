package com.entities.interfaces;

import java.util.List;

import com.entities.classes.Pedido;
import com.entities.classes.Endereco.EnderecoCliente;
import com.entities.classes.Telefone.TelefoneCliente;

public interface ClienteInterface {
    public void cadastrarEndereco(EnderecoCliente endereco);

    public void adicionarTelefone(TelefoneCliente telefone);

    public void removeEndereco();

    public boolean realizarPagamento(Float valor);

    public void listaPedido(List<Pedido> pedidos);
}