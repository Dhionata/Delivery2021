package br.com.controllers.usuario;

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
        var a = super.findAll();
        for (Cliente c : a) {
            c.setSenha(null);
        }
        return a;
    }

    @PostMapping(value = URL)
    private Cliente salvar(@RequestBody Cliente cliente) throws Exception {
        var a = super.save(new Cliente(cliente));
        a.setSenha(null);
        return a;
    }

    @DeleteMapping(URL)
    private void remover(@RequestBody Cliente cliente) {
        super.remove(cliente);
    }

    @PatchMapping(URL)
    private Cliente atualizar(@RequestBody Cliente cliente) throws Exception {
        if (cliente.getId() == null) {
            throw new Exception("ID não pode ser nulo!");
        }
        Cliente a;
        if (cliente.getSenha() == null) {
            a = super.save(cliente);
        } else {
            a = super.save(new Cliente(cliente));
        }
        a.setSenha(null);
        return a;
    }

    @GetMapping(URL + "/{id}")
    private Cliente procurarPorID(@PathVariable Integer id) {
        var a = super.findById(id);
        a.setSenha(null);
        return a;
    }

    @GetMapping(URL + "/Buscar")
    private Cliente find(@RequestBody Cliente cliente) {
        var a = super.findById(cliente.getId());
        a.setSenha(null);
        return a;
    }

    @Override
    public void validate(Cliente entity) throws Exception {
        if (entity.getEmail() == null || entity.getEmail().isEmpty()) {
            throw new Exception("\n\nEmail não pode ser vazio!\n\n");
        }

        if (entity.getNome() == null || entity.getNome().isEmpty()) {
            throw new Exception("\n\nNome não pode ser vazio!\n\n");
        }
    }
}