package com.entities.classes;

import com.entities.interfaces.EnderecoInterface;

public class Endereco implements EnderecoInterface {

    private int id;
    private String logradouro;
    private String cidade;
    private String bairro;
    private String complemento;
    private String cep;
    private String numero;
    private float coordenadaX;
    private float coordenaxaY;

    public Endereco(int id, String logradouro, String cidade, String bairro, String complemento, String cep,
            String numero, float coordenadaX, float coordenaxaY) {
        setId(id);
        setLogradouro(logradouro);
        setCidade(cidade);
        setBairro(bairro);
        setComplemento(complemento);
        setCep(cep);
        setNumero(numero);
        setCoordenadaX(coordenadaX);
        setCoordenaxaY(coordenaxaY);
    }

    @Override
    public String toString() {
        return "\n-- Endereço-- \nBairro: " + bairro + "\nCep: " + cep + "\nCidade: " + cidade + "\nComplemento: "
                + complemento + "\nCoordenada-X:" + coordenadaX + "\nCoordenaxa-Y:" + coordenaxaY + "\nID: " + id
                + "\nLogradouro: " + logradouro + "\nNumero: " + numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(float coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public float getCoordenaxaY() {
        return coordenaxaY;
    }

    public void setCoordenaxaY(float coordenaxaY) {
        this.coordenaxaY = coordenaxaY;
    }
}