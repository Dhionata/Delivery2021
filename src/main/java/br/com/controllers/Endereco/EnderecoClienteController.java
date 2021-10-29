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
import br.com.model.entities.classes.endereco.EnderecoCliente;
import br.com.repository.endereco.EnderecoClienteRepository;

@RestController
@CrossOrigin(origins = "*")
public class EnderecoClienteController extends GenericService<EnderecoCliente, EnderecoClienteRepository> {
    private final String URL = "/enderecoCliente";

    @Autowired
    public EnderecoClienteController(CrudRepository<EnderecoCliente, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    public Iterable<EnderecoCliente> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    public EnderecoCliente save(@RequestBody EnderecoCliente enderecoCliente) throws Exception {
        return super.save(enderecoCliente);
    }

    @DeleteMapping(URL + "/Remover/")
    public Object remove(@RequestBody EnderecoCliente enderecoCliente) {
        return super.remove(enderecoCliente);
    }

    @PatchMapping(URL + "/Atualizar/")
    public EnderecoCliente update(@RequestBody EnderecoCliente enderecoCliente) throws Exception {
        return super.save(enderecoCliente);
    }

    @GetMapping(URL + "/BuscarById/")
    public EnderecoCliente findById(@RequestBody Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    public EnderecoCliente find(@RequestBody EnderecoCliente enderecoCliente) {
        return super.findById(enderecoCliente.getId());
    }
}
