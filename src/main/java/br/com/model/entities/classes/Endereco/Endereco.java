package br.com.model.entities.classes.Endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.com.model.entities.interfaces.EnderecoInterface;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
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

    public Endereco() {
    }

    @Override
    public String toString() {
        return "\n-- Endereço--\nID: " + getId() + "\nBairro: " + getBairro() + "\nCep: " + getCep() + "\nCidade: "
                + getCidade() + "\nComplemento: " + getComplemento() + "\nCoordenada-X:" + getCoordenadaX()
                + "\nCoordenaxa-Y:" + getCoordenaxaY() + "\nLogradouro: " + getLogradouro() + "\nNumero: "
                + getNumero();
    }
}