package com.entities.classes;

import com.entities.interfaces.EnderecoInterface;

public class Endereco implements EnderecoInterface {
    int id;
    String logradouro;
    String cidade;
    String bairro;
    String complemento;
    String cep;
    String numero;
    float coordenadaX;
    float coordenaxaY;
}