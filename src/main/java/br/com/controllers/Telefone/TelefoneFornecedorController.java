package br.com.controllers.telefone;

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
import br.com.model.entities.classes.telefone.TelefoneFornecedor;
import br.com.repository.telefone.TelefoneFornecedorRepository;

@RestController
@CrossOrigin(origins = "*")
public class TelefoneFornecedorController extends GenericService<TelefoneFornecedor, TelefoneFornecedorRepository> {
    private final String URL = "/telefoneFornecedor";

    @Autowired
    public TelefoneFornecedorController(CrudRepository<TelefoneFornecedor, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    public Iterable<TelefoneFornecedor> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    public TelefoneFornecedor save(@RequestBody TelefoneFornecedor telefoneFornecedor) throws Exception {
        return super.save(telefoneFornecedor);
    }

    @DeleteMapping(URL + "/Remover/")
    public Object remove(@RequestBody TelefoneFornecedor telefoneFornecedor) {
        return super.remove(telefoneFornecedor);
    }

    @PatchMapping(URL + "/Atualizar/")
    public Object update(@RequestBody TelefoneFornecedor telefoneFornecedor) throws Exception {
        return super.save(telefoneFornecedor);
    }

    @GetMapping(URL + "/BuscarById/")
    public TelefoneFornecedor findById(@RequestBody Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar")
    public TelefoneFornecedor find(@RequestBody TelefoneFornecedor telefoneFornecedor) {
        return super.findById(telefoneFornecedor.getId());
    }
}
