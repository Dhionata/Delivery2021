package br.com.test.model.classes;

import br.com.model.entities.classes.Usuario.Cliente;

public class TesteCliente {
    public static void main(String[] args) {
        System.out.println(novoCliente().toString());
    }

    public static Cliente novoCliente() {
        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste123456", "teste@gmail.com");
        TesteTelefone.novaListaTelefoneCliente(cliente);
        TesteEndereco.novaListaEnderecoCliente(cliente);

        return cliente;
    }
}
