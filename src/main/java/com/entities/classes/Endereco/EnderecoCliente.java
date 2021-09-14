package com.entities.classes.Endereco;

import com.entities.classes.Cliente;

public class EnderecoCliente extends Endereco {

    private Cliente cliente;

    public EnderecoCliente(int id, Cliente cliente, String logradouro, String cidade, String bairro, String complemento,
            String cep, String numero, float coordenadaX, float coordenaxaY) {
        super(id, logradouro, cidade, bairro, complemento, cep, numero, coordenadaX, coordenaxaY);
        setCliente(cliente);
    }

    public EnderecoCliente(Endereco endereco, Cliente cliente) {
        super(endereco);
        setCliente(cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
