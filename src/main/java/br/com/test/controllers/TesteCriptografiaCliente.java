package br.com.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Services.GenericService;
import br.com.encrypt.Criptografia;
import br.com.model.entities.classes.Usuario.Cliente;
import br.com.repository.Usuario.ClienteRepository;
import br.com.test.model.classes.TesteCliente;

@RestController
public class TesteCriptografiaCliente extends GenericService<Cliente, ClienteRepository> {

    private final String URL = "/clienteTeste";
    private Cliente cliente = TesteCliente.novoCliente();

    @Autowired
    public TesteCriptografiaCliente(CrudRepository<Cliente, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Cliente save() {
        super.save(cliente);
        Criptografia.verificar(cliente, "teste123456");
        return cliente;
    }
}
