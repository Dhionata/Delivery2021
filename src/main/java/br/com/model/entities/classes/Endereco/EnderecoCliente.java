package br.com.model.entities.classes.Endereco;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.model.entities.classes.Usuario.Cliente;

@Entity
@PrimaryKeyJoinColumn(name = "id_endereco")
public class EnderecoCliente extends Endereco {

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Cliente cliente;

    public EnderecoCliente(Cliente cliente, String logradouro, String cidade, String bairro, String complemento,
            String cep, String numero, float coordenadaX, float coordenaxaY) {
        super(logradouro, cidade, bairro, complemento, cep, numero, coordenadaX, coordenaxaY);
        setCliente(cliente);
        getCliente().cadastrarEndereco(this);
    }

    public EnderecoCliente(Endereco endereco, Cliente cliente) {
        super(endereco);
        setCliente(cliente);
        getCliente().cadastrarEndereco(this);
    }

    public EnderecoCliente() {
    }

    // Getters / Setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}