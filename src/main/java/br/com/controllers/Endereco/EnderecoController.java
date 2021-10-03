package br.com.controllers.Endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Services.GenericService;
import br.com.model.entities.classes.Endereco.Endereco;
import br.com.repository.EnderecoRepository;

@RestController
public class EnderecoController extends GenericService<Endereco, EnderecoRepository> {
    private final String URL = "/endereco";

    @Autowired
    public EnderecoController(CrudRepository<Endereco, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Iterable<Endereco> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save() {
        return super.save(new Endereco());
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(Endereco endereco) {
        return super.update(endereco);
    }

    @GetMapping(URL + "/Buscar/")
    public Endereco findById(Integer id) {
        return super.findById(id);
    }
}
