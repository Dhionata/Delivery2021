package com.entities.classes.Endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.entities.interfaces.EnderecoInterface;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Endereco implements EnderecoInterface {
    @Id
    @GeneratedValue
    private Integer id;
    private String logradouro;
    private String cidade;
    private String bairro;
    private String complemento;
    private String cep;
    private String numero;
    private float coordenadaX;
    private float coordenaxaY;

    public Endereco(String logradouro, String cidade, String bairro, String complemento, String cep, String numero,
            float coordenadaX, float coordenaxaY) {
        setLogradouro(logradouro);
        setCidade(cidade);
        setBairro(bairro);
        setComplemento(complemento);
        setCep(cep);
        setNumero(numero);
        setCoordenadaX(coordenadaX);
        setCoordenaxaY(coordenaxaY);
    }

    public Endereco(Endereco endereco) {
        setId(endereco.getId());
        setLogradouro(endereco.getLogradouro());
        setCidade(endereco.getCidade());
        setBairro(endereco.getBairro());
        setComplemento(endereco.getComplemento());
        setCep(endereco.getCep());
        setNumero(endereco.getNumero());
        setCoordenadaX(endereco.getCoordenadaX());
        setCoordenaxaY(endereco.getCoordenaxaY());
    }

    @Override
    public String toString() {
        return "\n-- Endereço--\nID: " + getId() + "\nBairro: " + getBairro() + "\nCep: " + getCep() + "\nCidade: "
                + getCidade() + "\nComplemento: " + getComplemento() + "\nCoordenada-X:" + getCoordenadaX()
                + "\nCoordenaxa-Y:" + getCoordenaxaY() + "\nLogradouro: " + getLogradouro() + "\nNumero: "
                + getNumero();
    }

    // Getters/Setters

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