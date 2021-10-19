package br.com.newObjects.model.classes;

import java.util.ArrayList;
import java.util.List;

import br.com.model.entities.classes.Telefone.TelefoneCliente;
import br.com.model.entities.classes.Telefone.TelefoneFornecedor;
import br.com.model.entities.classes.Usuario.Cliente;
import br.com.model.entities.classes.Usuario.Fornecedor;

public class NovoTelefone {

    public static List<TelefoneFornecedor> novaListaTelefoneFornecedor(Fornecedor fornecedor) {
        var telefone1 = new TelefoneFornecedor(fornecedor, "(ii)thhhh-hhhh");
        var telefone2 = new TelefoneFornecedor(fornecedor, "(yy)qaaaa-zzzz");

        var lista = new ArrayList<TelefoneFornecedor>();
        lista.add(telefone1);
        lista.add(telefone2);
        return lista;
    }

    public static List<TelefoneCliente> novaListaTelefoneCliente(Cliente cliente) {
        var telefone1 = new TelefoneCliente(cliente, "(xx)yrrrr-rrrr");
        var telefone2 = new TelefoneCliente(cliente, "(xx)yrrrr-rrrr");

        var lista = new ArrayList<TelefoneCliente>();
        lista.add(telefone1);
        lista.add(telefone2);
        return lista;
    }
}
