package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.Services.GenericService;
import br.com.model.entities.classes.Cliente;
import br.com.repository.ClienteRepository;

public class ClienteController extends GenericService<Cliente, ClienteRepository> {

    private final String URL = "/cliente";

    @Autowired
    public ClienteController(CrudRepository<Cliente, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Object findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save() {
        return super.save(new Cliente());
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(Cliente cliente) {
        return super.update(cliente);
    }

    @GetMapping(URL + "/Buscar{id}")
    public Object findById(Integer id) {
        return super.findById(id);
    }

}
