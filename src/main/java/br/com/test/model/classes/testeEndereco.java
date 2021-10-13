package br.com.test.model.classes;

import java.util.ArrayList;
import java.util.List;

import br.com.model.entities.classes.Endereco.EnderecoCliente;
import br.com.model.entities.classes.Endereco.EnderecoFornecedor;
import br.com.model.entities.classes.Usuario.Cliente;
import br.com.model.entities.classes.Usuario.Fornecedor;

public class TesteEndereco {

    public static void main(String[] args) {
        System.out.println();
    }

    public static List<EnderecoCliente> novaListaEnderecoCliente(Cliente cliente) {
        EnderecoCliente enderecoCliente1 = new EnderecoCliente(cliente, "logradouro", "cidade", "bairro", "complemento",
                "cep", "numero", 0f, 0f);
        EnderecoCliente enderecoCliente2 = new EnderecoCliente(cliente, "logradouro2", "cidade2", "bairro2",
                "complemento2", "cep2", "numero2", 0f, 0f);

        List<EnderecoCliente> novaListaEnderecoCliente = new ArrayList<>();
        novaListaEnderecoCliente.add(enderecoCliente1);
        novaListaEnderecoCliente.add(enderecoCliente2);

        return novaListaEnderecoCliente;
    }

    public static List<EnderecoFornecedor> novaListaEnderecoFornecedor(Fornecedor fornecedor) {
        EnderecoFornecedor enderecoFornecedor1 = new EnderecoFornecedor(fornecedor, "logradouro", "cidade", "bairro",
                "complemento", "cep", "numero", 0f, 0f);
        EnderecoFornecedor enderecoFornecedor2 = new EnderecoFornecedor(fornecedor, "logradouro2", "cidade2", "bairro2",
                "complemento2", "cep2", "numero2", 0f, 0f);

        List<EnderecoFornecedor> novaListaEnderecoFornecedor = new ArrayList<>();
        novaListaEnderecoFornecedor.add(enderecoFornecedor1);
        novaListaEnderecoFornecedor.add(enderecoFornecedor2);

        return novaListaEnderecoFornecedor;
    }
}
