package br.com.test.repository;

import br.com.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testeClienteRepository {

    @Autowired
    private ClienteRepository clienteRepository;

    public static void main(String[] args) {
        
    }
}
