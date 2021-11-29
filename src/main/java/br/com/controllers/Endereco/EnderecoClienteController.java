package br.com.controllers.endereco;

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
import br.com.model.entities.classes.endereco.EnderecoCliente;
import br.com.repository.endereco.EnderecoClienteRepository;

@RestController
@CrossOrigin(origins = "*")
public class EnderecoClienteController extends GenericService<EnderecoCliente, EnderecoClienteRepository> {
    private final String URL = "/enderecoCliente";

    @Autowired
    private EnderecoClienteController(CrudRepository<EnderecoCliente, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    private Iterable<EnderecoCliente> procurarTodos() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    private EnderecoCliente salvar(@RequestBody EnderecoCliente enderecoCliente) throws Exception {
        return super.save(enderecoCliente);
    }

    @DeleteMapping(URL + "/Remover/")
    private Object remover(@RequestBody EnderecoCliente enderecoCliente) {
        return super.remove(enderecoCliente);
    }

    @PatchMapping(URL + "/Atualizar/")
    private EnderecoCliente atualizar(@RequestBody EnderecoCliente enderecoCliente) throws Exception {
        return super.save(enderecoCliente);
    }

    @GetMapping(URL + "/BuscarById/{id}")
    private EnderecoCliente procurarPorID(@PathVariable Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    private EnderecoCliente find(@RequestBody EnderecoCliente enderecoCliente) {
        return super.findById(enderecoCliente.getId());
    }

    @Override
    public void validate(EnderecoCliente entity) throws Exception {
        // TODO Auto-generated method stub
        
    }
}
