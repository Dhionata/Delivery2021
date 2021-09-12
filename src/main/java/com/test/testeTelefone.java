package com.test;

import com.entities.classes.Cliente;
import com.entities.classes.Endereco;
import com.entities.classes.Fornecedor;
import com.entities.classes.Telefone.TelefoneCliente;
import com.entities.classes.Telefone.TelefoneFornecedor;

public class testeTelefone {
    public static void main(String[] args) {

        Cliente cliente = new Cliente(1, "NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");

        TelefoneCliente telefoneDoCliente = new TelefoneCliente(cliente, 1, "(xx)yrrrr-rrrr");

        cliente.setTelefone(telefoneDoCliente);

        System.out.println(cliente.toString());

        Fornecedor fornecedor = new Fornecedor(1, "NomeFornecedorTeste", "O Allan é gay", new Endereco(2, "Anhanguera",
                "Goiânia", "Cerrado", "Q.0, L.0", "0000000-00", "S/N", 0.000000F, 0.000000F), "123.456.789-12");

        TelefoneFornecedor telefoneDoFornecedor = new TelefoneFornecedor(fornecedor, 2, "(yy)qaaaa-zzzz");
        fornecedor.setTelefone(telefoneDoFornecedor);

        System.out.println(fornecedor.toString());
    }
}
