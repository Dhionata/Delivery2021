package br.com.test.classes;

import br.com.entities.classes.Cliente;
import br.com.entities.classes.Fornecedor;
import br.com.entities.classes.Telefone.TelefoneCliente;
import br.com.entities.classes.Telefone.TelefoneFornecedor;

public class testeTelefone {
    public static void main(String[] args) {

        // cliente
        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");

        TelefoneCliente telefoneDoCliente = new TelefoneCliente(cliente, "(xx)yrrrr-rrrr");
        TelefoneCliente telefoneDoCliente2 = new TelefoneCliente(cliente, "(xx)yrrrr-rrrr");

        System.out.println(cliente.toString());

        // fornecedor
        Fornecedor fornecedor = new Fornecedor("NomeFornecedorTeste", "O Allan é gay", "123.456.789-12");
        TelefoneFornecedor telefoneFornecedor = new TelefoneFornecedor(fornecedor, "(ii)thhhh-hhhh");
        TelefoneFornecedor telefoneDoFornecedor = new TelefoneFornecedor(fornecedor, "(yy)qaaaa-zzzz");

        System.out.println(fornecedor.toString());
    }
}
