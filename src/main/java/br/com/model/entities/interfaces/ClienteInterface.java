package br.com.model.entities.interfaces;

import java.util.List;

import br.com.model.entities.classes.Pedido;
import br.com.model.entities.classes.endereco.EnderecoCliente;
import br.com.model.entities.classes.telefone.TelefoneCliente;

public interface ClienteInterface {
    public void cadastrarEndereco(EnderecoCliente endereco);

    public void removeEndereco(EnderecoCliente endereco);

    public void adicionarTelefone(TelefoneCliente telefone);

    public void removerTelefone(TelefoneCliente telefone);

    public boolean realizarPagamento(Float valor);

    // verificar!
    public void listaPedidos(List<Pedido> pedidos);
}