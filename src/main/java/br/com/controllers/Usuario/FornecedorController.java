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

    @PostMapping(value = URL + "/Adicionar/")
    private Fornecedor salvar(@RequestBody Fornecedor fornecedor) throws Exception {
        return super.save(fornecedor);
    }

    @DeleteMapping(URL + "/Remover/")
    private Object remover(@RequestBody Fornecedor fornecedor) {
        return super.remove(fornecedor);
    }

    @PatchMapping(URL + "/Atualizar/")
    private Object update(@RequestParam Fornecedor fornecedor) throws Exception {
        return super.save(fornecedor);
    }

    @GetMapping(URL + "/Buscar/")
    private Fornecedor procurarPorID(@RequestBody Integer id) {
        return super.findById(id);
    }

}
