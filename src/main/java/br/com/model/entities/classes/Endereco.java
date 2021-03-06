package br.com.model.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.model.entities.classes.usuario.Usuario;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Endereco {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Usuario usuario;

    private String logradouro;
    private String cidade;
    private String bairro;
    private String complemento;
    private String cep;
    private String numero;
    private float coordenadaX;
    private float coordenadaY;

    public Endereco(Usuario usuario, String logradouro, String cidade, String bairro, String complemento, String cep,
            String numero,
            float coordenadaX, float coordenadaY) {
        setLogradouro(logradouro);
        setCidade(cidade);
        setBairro(bairro);
        setComplemento(complemento);
        setCep(cep);
        setNumero(numero);
        setCoordenadaX(coordenadaX);
        setcoordenadaY(coordenadaY);
        setUsuario(usuario);
        getUsuario().cadastrarEndereco(this);
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
        setcoordenadaY(endereco.getcoordenadaY());
        setUsuario(endereco.getUsuario());
        getUsuario().cadastrarEndereco(this);
    }

    public Endereco() {
    }

    @Override
    public String toString() {
        return "\n\n-- Endereço--\nID: " + getId() + "\nBairro: " + getBairro() + "\nCep: " + getCep() + "\nCidade: "
                + getCidade() + "\nComplemento: " + getComplemento() + "\nCoordenada-X:" + getCoordenadaX()
                + "\nCoordenaxa-Y:" + getcoordenadaY() + "\nLogradouro: " + getLogradouro() + "\nNumero: "
                + getNumero() + "\nUsuario: " + getUsuario().getNome();
    }

    // Getters / Setters

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public float getcoordenadaY() {
        return coordenadaY;
    }

    public void setcoordenadaY(float coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

}