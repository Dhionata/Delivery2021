package br.com.newObjects.model.classes;

import br.com.model.entities.classes.Usuario.Cliente;

public class NovoCliente {

    public static Cliente novoCliente() {
        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste123456", "teste@gmail.com");
        NovoTelefone.novaListaTelefoneCliente(cliente);
        NovoEndereco.novaListaEnderecoCliente(cliente);

        return cliente;
    }
}
