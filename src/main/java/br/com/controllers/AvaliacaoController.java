package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Services.GenericService;
import br.com.model.entities.classes.Avaliacao;
import br.com.repository.AvaliacaoRepository;

@RestController
public class AvaliacaoController extends GenericService<Avaliacao, AvaliacaoRepository> {

    private final String URL = "/avaliacao";

    @Autowired
    public AvaliacaoController(CrudRepository<Avaliacao, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Object findAll() {
        return super.findAll();
    }

    @GetMapping(URL + "/Buscar/")
    public Avaliacao findById(Integer id) {
        return super.findById(id);
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save() {
        return super.save(new Avaliacao());
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(Avaliacao avaliacao) {
        return super.update(avaliacao);
    }

}
