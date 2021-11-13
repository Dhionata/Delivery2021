package br.com.controllers.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.services.GenericService;
import br.com.model.entities.classes.usuario.Cliente;
import br.com.repository.usuario.ClienteRepository;

@RestController
@CrossOrigin(origins = "*")
public class ClienteController extends GenericService<Cliente, ClienteRepository> {

    private final String URL = "/cliente";

    @Autowired
    private ClienteController(CrudRepository<Cliente, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    private Iterable<Cliente> procurarTodos() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    private Cliente salvar(@RequestBody Cliente cliente) throws Exception {
        return super.save(cliente);
    }

    @DeleteMapping(URL + "/Remover/")
    private Object remover(@RequestBody Cliente cliente) {
        return super.remove(cliente);
    }

    @PatchMapping(URL + "/Atualizar/")
    private Object atualizar(@RequestBody Cliente cliente) throws Exception {
        return super.save(cliente);
    }

    @GetMapping(URL + "/BuscarById/")
    private Cliente procurarPorID(@RequestParam Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar")
    private Cliente find(@RequestBody Cliente cliente) {
        return super.findById(cliente.getId());
    }
}