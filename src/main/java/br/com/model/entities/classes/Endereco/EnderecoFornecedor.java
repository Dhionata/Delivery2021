package br.com.model.entities.classes.Endereco;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.com.model.entities.classes.Fornecedor;
import lombok.Data;

@Entity
@PrimaryKeyJoinColumn(name = "id_endereco")
@Data
public class EnderecoFornecedor extends Endereco {

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
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

    public EnderecoFornecedor() {
    }

}