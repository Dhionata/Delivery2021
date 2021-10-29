package br.com.controllers.endereco;

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

import br.com.services.GenericService;
import br.com.model.entities.classes.endereco.EnderecoFornecedor;
import br.com.repository.endereco.EnderecoFornecedorRepository;

@RestController
@CrossOrigin(origins = "*")
public class EnderecoFornecedorController extends GenericService<EnderecoFornecedor, EnderecoFornecedorRepository> {
    private final String URL = "/enderecoFornecedor";

    @Autowired
    public EnderecoFornecedorController(CrudRepository<EnderecoFornecedor, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    public Iterable<EnderecoFornecedor> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    public EnderecoFornecedor save(@RequestBody EnderecoFornecedor enderecoFornecedor) throws Exception {
        return super.save(enderecoFornecedor);
    }

    @DeleteMapping(URL + "/Remover/")
    public Object remove(@RequestBody EnderecoFornecedor enderecoFornecedor) {
        return super.remove(enderecoFornecedor);
    }

    @PatchMapping(URL + "/Atualizar/")
    public Object update(@RequestBody EnderecoFornecedor enderecoFornecedor) throws Exception {
        return super.save(enderecoFornecedor);
    }

    @GetMapping(URL + "/BuscarById/")
    public EnderecoFornecedor findById(@RequestBody Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    public EnderecoFornecedor find(@RequestBody EnderecoFornecedor enderecoFornecedor) {
        return super.findById(enderecoFornecedor.getId());
    }
}
