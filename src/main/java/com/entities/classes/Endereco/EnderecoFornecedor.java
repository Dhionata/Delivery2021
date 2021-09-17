package com.entities.classes.Endereco;

import com.entities.classes.Fornecedor;

public class EnderecoFornecedor extends Endereco {

    private Fornecedor fornecedor;

    public EnderecoFornecedor(Fornecedor fornecedor, String logradouro, String cidade, String bairro,
            String complemento, String cep, String numero, float coordenadaX, float coordenaxaY) {

        super(logradouro, cidade, bairro, complemento, cep, numero, coordenadaX, coordenaxaY);
        setFornecedor(fornecedor);
        getFornecedor().setEndereco(this);
    }

    public EnderecoFornecedor(Fornecedor fornecedor, Endereco endereco) {
        super(endereco);
        setFornecedor(fornecedor);
        getFornecedor().setEndereco(this);
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

}
