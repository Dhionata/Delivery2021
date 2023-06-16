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

import br.com.model.entities.classes.usuario.Fornecedor;
import br.com.services.classes.usuario.FornecedorService;

@RestController
@CrossOrigin(origins = "*")
public class FornecedorController extends FornecedorService {

    private final String URL = "/fornecedor";

    @GetMapping(URL)
    protected ResponseEntity<Iterable<Fornecedor>> procurarTodos() {
        return super.procurarTodos();
    }

    @PostMapping(URL)
    public ResponseEntity<Fornecedor> salvar(@RequestBody Fornecedor fornecedor) throws Exception {
        return super.salvar(fornecedor);
    }

    @DeleteMapping(URL)
    public ResponseEntity<String> remover(@RequestBody Fornecedor fornecedor) throws Exception {
        return super.remover(fornecedor);
    }

    @PatchMapping(URL)
    public ResponseEntity<Fornecedor> atualizar(@RequestBody Fornecedor fornecedor) throws Exception {
        return super.atualizar(fornecedor);
    }

    @GetMapping(URL + "/{id}")
    public ResponseEntity<Fornecedor> procurarPorID(@PathVariable Integer id) {
        return super.procurarPorID(id);
    }

    @GetMapping(URL + "/Buscar")
    public ResponseEntity<Fornecedor> buscarPorCnpjCpf(@RequestBody Fornecedor fornecedor) {
        return super.buscar(fornecedor.getCnpjCpf());
    }

    @Override
    public void validate(Fornecedor entity) throws Exception {
        if (entity.getEmail() == null || entity.getEmail().isEmpty()) {
            throw new Exception("\n\nEmail não pode ser vazio!\n\n");
        }

        if (entity.getNome() == null || entity.getNome().isEmpty()) {
            throw new Exception("\n\nNome não pode ser vazio!\n\n");
        }
    }

}
