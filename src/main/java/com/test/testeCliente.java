package com.test;

import com.entities.classes.Cliente;

public class testeCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");
        System.out.println(cliente.toString());
    }
}
