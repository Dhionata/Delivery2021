package br.com.test.model.classes;

import br.com.model.entities.classes.Cliente;

public class testeCliente {
    public static void main(String[] args) {
        System.out.println(novoCliente().toString());
    }

    public static Cliente novoCliente() {
        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");
        testeTelefone.novaListaTelefoneCliente(cliente);
        testeEndereco.novaListaEnderecoCliente(cliente);

        return cliente;
    }
}
