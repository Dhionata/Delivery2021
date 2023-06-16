package br.com.controllers.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.services.classes.usuario.ClienteService;
import br.com.model.entities.classes.usuario.Cliente;

@RestController
@CrossOrigin(origins = "*")
public class ClienteController extends ClienteService {

    private final String URL = "/cliente";

    @GetMapping(value = URL)
    protected ResponseEntity<Iterable<Cliente>> procurarTodos() {
        return super.procurarTodos();
    }

    @PostMapping(value = URL)
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) throws Exception {
        return super.salvar(cliente);
    }

    @DeleteMapping(URL)
    public ResponseEntity<String> remover(@RequestBody Cliente cliente) throws Exception {
        return super.remover(cliente);
    }

    @PatchMapping(URL)
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente) throws Exception {
        return super.atualizar(cliente);
    }

    @GetMapping(URL + "/{id}")
    public ResponseEntity<Cliente> procurarPorID(@PathVariable Integer id) {
        return super.procurarPorID(id);
    }

    @GetMapping(URL + "/Buscar")
    public ResponseEntity<Cliente> buscarPorCnpjCpf(@RequestBody Cliente cliente) {
        return super.buscarPorCnpjCpf(cliente.getCnpjCpf());
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