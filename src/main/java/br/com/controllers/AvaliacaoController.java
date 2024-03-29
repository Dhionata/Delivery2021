package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.services.GenericService;
import br.com.model.entities.classes.Avaliacao;

@RestController
@CrossOrigin(origins = "*")
public class AvaliacaoController extends GenericService<Avaliacao, Integer> {

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

    @PostMapping(value = URL)
    private Avaliacao salvar(@RequestBody Avaliacao avaliacao) throws Exception {
        return super.save(avaliacao);
    }

    @DeleteMapping(URL)
    private void remover(@RequestBody Avaliacao avaliacao) {
        super.remove(avaliacao);
    }

    @PatchMapping(URL)
    private Avaliacao atualizar(@RequestBody Avaliacao avaliacao) throws Exception {
        return super.save(avaliacao);
    }

    @GetMapping(URL + "/{id}")
    private Avaliacao procurarPorID(@PathVariable Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    private Avaliacao find(@RequestBody Avaliacao avaliacao) {
        return super.findById(avaliacao.getId());
    }

    @Override
    public void validate(Avaliacao entity) throws Exception {
        if (entity.getNota() != null && entity.getPedido() != null) {
            return;
        } else {
            throw new Exception("Avaliação não válida!");
        }
    }
}
