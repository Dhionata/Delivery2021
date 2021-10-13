package br.com.controllers.Endereco;

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
import br.com.model.entities.classes.Endereco.EnderecoCliente;
import br.com.repository.Endereco.EnderecoClienteRepository;

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
    public Object save(@RequestBody EnderecoCliente enderecoCliente) {
        return super.save(enderecoCliente);
    }

    @DeleteMapping(URL + "/Remover/")
    public Object remove(@RequestBody EnderecoCliente enderecoCliente) {
        return super.remove(enderecoCliente);
    }

    @PatchMapping(URL + "/Atualizar/")
    public Object update(@RequestBody EnderecoCliente enderecoCliente) {
        return super.update(enderecoCliente);
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
