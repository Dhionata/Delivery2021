package br.com.entities.interfaces;

import java.util.List;

import br.com.entities.classes.Pedido;
import br.com.entities.classes.Endereco.EnderecoCliente;
import br.com.entities.classes.Telefone.TelefoneCliente;

public interface ClienteInterface {
    public void cadastrarEndereco(EnderecoCliente endereco);

    public void adicionarTelefone(TelefoneCliente telefone);

    public void removeEndereco(EnderecoCliente endereco);

    public boolean realizarPagamento(Float valor);

    // verificar!
    public void listaPedidos(List<Pedido> pedidos);
}