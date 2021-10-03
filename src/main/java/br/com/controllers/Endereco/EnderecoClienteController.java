package br.com.controllers.Endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Services.GenericService;
import br.com.model.entities.classes.Endereco.EnderecoCliente;
import br.com.repository.EnderecoClienteRepository;

@RestController
public class EnderecoClienteController extends GenericService<EnderecoCliente, EnderecoClienteRepository> {
    private final String URL = "/enderecoCliente";

    @Autowired
    public EnderecoClienteController(CrudRepository<EnderecoCliente, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Iterable<EnderecoCliente> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save() {
        return super.save(new EnderecoCliente());
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(EnderecoCliente enderecoCliente) {
        return super.update(enderecoCliente);
    }

    @GetMapping(URL + "/Buscar/")
    public EnderecoCliente findById(Integer id) {
        return super.findById(id);
    }
}
