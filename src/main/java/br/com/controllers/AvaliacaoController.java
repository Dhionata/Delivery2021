package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.services.GenericService;
import br.com.model.entities.classes.Avaliacao;
import br.com.repository.AvaliacaoRepository;

@RestController
@CrossOrigin(origins = "*")
public class AvaliacaoController extends GenericService<Avaliacao, AvaliacaoRepository> {

    private final String URL = "/avaliacao";

    @Autowired
    private AvaliacaoController(CrudRepository<Avaliacao, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    private Iterable<Avaliacao> todos() {
        return super.findAll();
    }

    @GetMapping(URL + "/Buscar/")
    private Avaliacao find(@RequestBody Avaliacao avaliacao) {
        return super.findById(avaliacao.getId());
    }

    @GetMapping(URL + "/BuscarById/")
    private Avaliacao procurarPorID(@RequestBody Integer id) {
        return super.findById(id);
    }

    @PostMapping(value = URL + "/Adicionar/")
    private Avaliacao salvar(@RequestBody Avaliacao avaliacao) throws Exception {
        return super.save(avaliacao);
    }

    @DeleteMapping(URL + "/Remover/")
    private Object remover(@RequestBody Avaliacao avaliacao) {
        return super.remove(avaliacao);
    }

    @PatchMapping(URL + "/Atualizar/")
    private Object update(@RequestBody Avaliacao avaliacao) throws Exception {
        return super.save(avaliacao);
    }

}
