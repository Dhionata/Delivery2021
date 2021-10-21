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
import br.com.model.entities.classes.usuario.Fornecedor;
import br.com.repository.Usuario.FornecedorRepository;

@RestController
@CrossOrigin(origins = "*")
public class FornecedorController extends GenericService<Fornecedor, FornecedorRepository> {

    private final String URL = "/fornecedor";

    @Autowired
    public FornecedorController(CrudRepository<Fornecedor, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    public Iterable<Fornecedor> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    public Fornecedor save(@RequestBody Fornecedor fornecedor) throws Exception {
        return super.save(fornecedor);
    }

    @DeleteMapping(URL + "/Remover/")
    public Object remove(@RequestBody Fornecedor fornecedor) {
        return super.remove(fornecedor);
    }

    @PatchMapping(URL + "/Atualizar/")
    public Object update(@RequestBody Fornecedor fornecedor) throws Exception {
        return super.save(fornecedor);
    }

    @GetMapping(URL + "/Buscar/")
    public Fornecedor findById(@RequestBody Integer id) {
        return super.findById(id);
    }

}
