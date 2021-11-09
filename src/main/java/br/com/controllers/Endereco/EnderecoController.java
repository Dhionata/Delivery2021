package br.com.controllers.endereco;

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
import br.com.model.entities.classes.endereco.Endereco;
import br.com.repository.endereco.EnderecoRepository;

@RestController
@CrossOrigin(origins = "*")
public class EnderecoController extends GenericService<Endereco, EnderecoRepository> {
    private final String URL = "/endereco";

    @Autowired
    private EnderecoController(CrudRepository<Endereco, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    private Iterable<Endereco> procurarTodos() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    private Endereco salvar(@RequestBody Endereco endereco) throws Exception {
        return super.save(endereco);
    }

    @DeleteMapping(URL + "/Remover/")
    private Object remover(@RequestBody Endereco endereco) {
        return super.remove(endereco);
    }

    @PatchMapping(URL + "/Atualizar/")
    private Endereco update(@RequestBody Endereco endereco) throws Exception {
        return super.save(endereco);
    }

    @GetMapping(URL + "/BuscarById/")
    private Endereco procurarPorID(@RequestBody Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    private Endereco find(@RequestBody Endereco endereco) {
        return super.findById(endereco.getId());
    }
}
