package br.com.controllers.Usuario;

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
import br.com.model.entities.classes.Usuario.Cliente;
import br.com.repository.Usuario.ClienteRepository;

@RestController
@CrossOrigin(origins = "*")
public class ClienteController extends GenericService<Cliente, ClienteRepository> {

    private final String URL = "/cliente";

    @Autowired
    public ClienteController(CrudRepository<Cliente, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    public Iterable<Cliente> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    public Object save(@RequestBody Cliente cliente) {
        return super.save(cliente);
    }

    @DeleteMapping(URL + "/Remover/")
    public Object remove(@RequestBody Cliente cliente) {
        return super.remove(cliente);
    }

    @PatchMapping(URL + "/Atualizar/")
    public Object update(@RequestBody Cliente cliente) {
        return super.update(cliente);
    }

    @GetMapping(URL + "/BuscarById/")
    public Cliente findById(Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar")
    public Cliente find(@RequestBody Cliente cliente) {
        return super.findById(cliente.getId());
    }
}
