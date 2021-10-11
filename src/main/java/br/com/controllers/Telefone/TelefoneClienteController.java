package br.com.controllers.Telefone;

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
import br.com.model.entities.classes.Telefone.TelefoneCliente;
import br.com.repository.TelefoneClienteRepository;

@RestController
@CrossOrigin(origins = "*")
public class TelefoneClienteController extends GenericService<TelefoneCliente, TelefoneClienteRepository> {
    private final String URL = "/telefoneCliente";

    @Autowired
    public TelefoneClienteController(CrudRepository<TelefoneCliente, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    public Iterable<TelefoneCliente> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    public Object save(@RequestBody TelefoneCliente telefoneCliente) {
        return super.save(telefoneCliente);
    }

    @DeleteMapping(URL + "/Remover/")
    public Object remove(@RequestBody TelefoneCliente telefoneCliente) {
        return super.remove(telefoneCliente);
    }

    @PatchMapping(URL + "/Atualizar/")
    public Object update(@RequestBody TelefoneCliente telefoneCliente) {
        return super.update(telefoneCliente);
    }

    @GetMapping(URL + "/BuscarById/")
    public TelefoneCliente findById(@RequestBody Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    public TelefoneCliente find(@RequestBody TelefoneCliente telefoneCliente) {
        return super.findById(telefoneCliente.getId());
    }
}
