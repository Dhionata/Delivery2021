package com.test;

import com.entities.classes.Cliente;
import com.entities.classes.Endereco.Endereco;
import com.entities.classes.Endereco.EnderecoCliente;

public class testeCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");
        Endereco endereco = new Endereco("logradouro", "cidade", "bairro", "complemento", "cep", "numero", 0f, 0f);
        EnderecoCliente enderecoCliente = new EnderecoCliente(endereco, cliente);
        cliente.cadastrarEndereco(enderecoCliente);

        System.out.println(cliente.toString());
    }
}
