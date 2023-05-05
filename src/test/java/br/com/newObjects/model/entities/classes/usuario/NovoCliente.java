package br.com.newObjects.model.entities.classes.usuario;

import br.com.model.entities.classes.usuario.Cliente;
import br.com.newObjects.model.entities.classes.NovoEndereco;
import br.com.newObjects.model.entities.classes.NovoTelefone;

public class NovoCliente {

    public static Cliente novoCliente() {
        Cliente cliente = new Cliente("NomeClienteTeste",
                "000.000.000-00", "teste123456", "teste@gmailCliente.com");
        NovoTelefone.novaListaTelefones(cliente);
        NovoEndereco.novaListaEndereco(cliente);

        return cliente;
    }
}
