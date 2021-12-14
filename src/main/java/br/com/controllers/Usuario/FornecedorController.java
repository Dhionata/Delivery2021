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
import br.com.model.entities.classes.usuario.Fornecedor;
import br.com.repository.usuario.FornecedorRepository;

@RestController
@CrossOrigin(origins = "*")
public class FornecedorController extends GenericService<Fornecedor, FornecedorRepository> {

    private final String URL = "/fornecedor";

    @Autowired
    private FornecedorController(CrudRepository<Fornecedor, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    private Iterable<Fornecedor> procurarTodos() {
        return super.findAll();
    }

    @PostMapping(value = URL)
    private Fornecedor salvar(@RequestBody Fornecedor fornecedor) throws Exception {
        return super.save(fornecedor);
    }

    @DeleteMapping(URL)
    private void remover(@RequestBody Fornecedor fornecedor) {
        super.remove(fornecedor);
        System.out.println("Fornecedor removido com sucesso!");
    }

    @PatchMapping(URL)
    private Fornecedor atualizar(@RequestBody Fornecedor fornecedor) throws Exception {
        return super.save(fornecedor);
    }

    @GetMapping(URL + "/{id}")
    private Fornecedor procurarPorID(@PathVariable Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    private Fornecedor procurar(@RequestBody Fornecedor fornecedor) {
        return super.findById(fornecedor.getId());
    }

    @Override
    public void validate(Fornecedor entity) throws Exception {
        if (entity.getNome() == null || entity.getNome().isEmpty()) {
            throw new Exception("Nome não pode ser vazio!");
        }
        if (entity.getCnpjCpf() == null || entity.getCnpjCpf().isEmpty()) {
            throw new Exception("CNPJ não pode ser vazio!");
        }
        if (entity.getEmail() == null || entity.getEmail().isEmpty()) {
            throw new Exception("Email não pode ser vazio!");
        }
    }

}
