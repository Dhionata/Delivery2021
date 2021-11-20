package br.com.controllers.telefone;

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
import br.com.model.entities.classes.telefone.Telefone;
import br.com.repository.telefone.TelefoneRepository;

@RestController
@CrossOrigin(origins = "*")
public class TelefoneController extends GenericService<Telefone, TelefoneRepository> {
    private final String URL = "/telefone";

    @Autowired
    private TelefoneController(CrudRepository<Telefone, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    private Iterable<Telefone> procurarTodos() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    private Telefone salvar(@RequestBody Telefone telefone) throws Exception {
        return super.save(telefone);
    }

    @DeleteMapping(URL + "/Remover/")
    private Object remover(@RequestBody Telefone telefone) {
        return super.remove(telefone);
    }

    @PatchMapping(URL + "/Atualizar/")
    private Telefone atualizar(@RequestBody Telefone telefone) throws Exception {
        return super.save(telefone);
    }

    @GetMapping(URL + "/BuscarById/{id}")
    private Telefone procurarPorID(@PathVariable Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    private Telefone find(@RequestBody Telefone telefone) {
        return super.findById(telefone.getId());
    }
}
