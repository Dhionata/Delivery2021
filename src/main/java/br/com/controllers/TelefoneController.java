package br.com.controllers;

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
import br.com.model.entities.classes.Telefone;

@RestController
@CrossOrigin(origins = "*")
public class TelefoneController extends GenericService<Telefone, Integer> {
    private final String URL = "/telefone";

    @Autowired
    private TelefoneController(CrudRepository<Telefone, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    private Iterable<Telefone> procurarTodos() {
        return super.findAll();
    }

    @PostMapping(value = URL)
    private Telefone salvar(@RequestBody Telefone telefone) throws Exception {
        System.out.println("\n\nTelefone a ser salvo: " + telefone.toString());
        return super.save(telefone);
    }

    @DeleteMapping(URL)
    private void remover(@RequestBody Telefone telefone) {
        System.out.println("\n\nRemovendo telefone: " + telefone.toString());
        super.remove(telefone);
        System.out.println("Telefone removido com sucesso!");
    }

    @PatchMapping(URL)
    private Telefone atualizar(@RequestBody Telefone telefone) throws Exception {
        System.out.println("\n\nAtualizando telefone" + telefone.toString());
        return super.save(telefone);
    }

    @GetMapping(URL + "/{id}")
    private Telefone procurarPorID(@PathVariable Integer id) {
        System.out.println("\n\nProcurando telefone por ID: " + id);
        var a = super.findById(id);
        System.out.println("\n\nTelefone encontrado: " + a.toString());
        return a;
    }

    @GetMapping(URL + "/Buscar/")
    private Telefone find(@RequestBody Telefone telefone) {
        return super.findById(telefone.getId());
    }

    @Override
    public void validate(Telefone entity) throws Exception {
        if (entity.getNumero().isEmpty()) {
            throw new Exception("Número não pode ser nulo");
        }
    }
}
