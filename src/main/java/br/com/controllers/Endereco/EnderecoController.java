package br.com.controllers.Endereco;

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
import br.com.model.entities.classes.Endereco.Endereco;
import br.com.repository.Endereco.EnderecoRepository;

@RestController
@CrossOrigin(origins = "*")
public class EnderecoController extends GenericService<Endereco, EnderecoRepository> {
    private final String URL = "/endereco";

    @Autowired
    public EnderecoController(CrudRepository<Endereco, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    public Iterable<Endereco> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    public Endereco save(@RequestBody Endereco endereco) throws Exception {
        return super.save(endereco);
    }

    @DeleteMapping(URL + "/Remover/")
    public Object remove(@RequestBody Endereco endereco) {
        return super.remove(endereco);
    }

    @PatchMapping(URL + "/Atualizar/")
    public Endereco update(@RequestBody Endereco endereco) throws Exception {
        return super.save(endereco);
    }

    @GetMapping(URL + "/BuscarById/")
    public Endereco findById(@RequestBody Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    public Endereco find(@RequestBody Endereco endereco) {
        return super.findById(endereco.getId());
    }
}
