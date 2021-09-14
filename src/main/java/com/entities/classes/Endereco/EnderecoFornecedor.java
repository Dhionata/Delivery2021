package com.entities.classes.Endereco;

import com.entities.classes.Fornecedor;

public class EnderecoFornecedor extends Endereco {

    private Fornecedor fornecedor;

    public EnderecoFornecedor(int id, Fornecedor fornecedor, String logradouro, String cidade, String bairro,
            String complemento, String cep, String numero, float coordenadaX, float coordenaxaY) {

        super(id, logradouro, cidade, bairro, complemento, cep, numero, coordenadaX, coordenaxaY);
        setFornecedor(fornecedor);
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

}
