package br.com.controllers.Telefone;

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

import br.com.Services.GenericService;
import br.com.model.entities.classes.telefone.Telefone;
import br.com.repository.Telefone.TelefoneRepository;

@RestController
@CrossOrigin(origins = "*")
public class TelefoneController extends GenericService<Telefone, TelefoneRepository> {
    private final String URL = "/telefone";

    @Autowired
    public TelefoneController(CrudRepository<Telefone, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    public Iterable<Telefone> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    public Telefone save(@RequestBody Telefone telefone) throws Exception {
        return super.save(telefone);
    }

    @DeleteMapping(URL + "/Remover/")
    public Object remove(@RequestBody Telefone telefone) {
        return super.remove(telefone);
    }

    @PatchMapping(URL + "/Atualizar/")
    public Object update(@RequestBody Telefone telefone) throws Exception {
        return super.save(telefone);
    }

    @GetMapping(URL + "/BuscarById/")
    public Telefone findById(@RequestBody Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    public Telefone find(@RequestBody Telefone telefone) {
        return super.findById(telefone.getId());
    }
}
