package br.com.test;

import br.com.entities.classes.*;
import br.com.entities.classes.Endereco.EnderecoCliente;
import br.com.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteTudoDB {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping("/solicitacao")
    public String solicitacao() {
        // cliente
        System.out.println("Entrou no método 'solicitacao'");
        Cliente cliente = new Cliente("NomeClienteTeste", "000.000.000-00", "teste@gmail.com", "teste123456");
        EnderecoCliente enderecoCliente = new EnderecoCliente(cliente, "logradouro", "cidade", "bairro", "complemento",
                "cep", "numero", 0f, 0f);

        System.out.println(cliente.toString());
        // clienteRepository.save(cliente);
        return "salvou!";
    }
}