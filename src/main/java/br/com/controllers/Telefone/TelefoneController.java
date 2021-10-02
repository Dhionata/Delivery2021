package br.com.controllers.Telefone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.Services.GenericService;
import br.com.model.entities.classes.Telefone.Telefone;
import br.com.repository.TelefoneRepository;

public class TelefoneController extends GenericService<Telefone, TelefoneRepository> {
    private final String URL = "/telefone";

    @Autowired
    public TelefoneController(CrudRepository<Telefone, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Object findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save() {
        return super.save(new Telefone());
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(Telefone telefone) {
        return super.update(telefone);
    }

    @GetMapping(URL + "/Buscar{id}")
    public Object findById(Integer id) {
        return super.findById(id);
    }
}
