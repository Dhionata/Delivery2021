package br.com.controllers.Telefone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Services.GenericService;
import br.com.model.entities.classes.Telefone.TelefoneCliente;
import br.com.repository.TelefoneClienteRepository;

@RestController
public class TelefoneClienteController extends GenericService<TelefoneCliente, TelefoneClienteRepository> {
    private final String URL = "/telefoneCliente";

    @Autowired
    public TelefoneClienteController(CrudRepository<TelefoneCliente, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Iterable<TelefoneCliente> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save() {
        return super.save(new TelefoneCliente());
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(TelefoneCliente telefoneCliente) {
        return super.update(telefoneCliente);
    }

    @GetMapping(URL + "/Buscar/")
    public TelefoneCliente findById(Integer id) {
        return super.findById(id);
    }
}
