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
import br.com.model.entities.classes.Endereco;

@RestController
@CrossOrigin(origins = "*")
public class EnderecoController extends GenericService<Endereco, Integer> {
    private final String URL = "/endereco";

    @Autowired
    private EnderecoController(CrudRepository<Endereco, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    private Iterable<Endereco> procurarTodos() {
        return super.findAll();
    }

    @PostMapping(value = URL)
    private Endereco salvar(@RequestBody Endereco endereco) throws Exception {
        return super.save(endereco);
    }

    @DeleteMapping(URL)
    private void remover(@RequestBody Endereco endereco) {
        try {
            System.out.println(endereco.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n\nRequisição de remoção de endereço recebida!\n\n");
        super.remove(endereco);
        System.out.println("\n\nEndereço removido com sucesso!\n\n");
    }

    @PatchMapping(URL)
    private Endereco atualizar(@RequestBody Endereco endereco) throws Exception {
        return super.save(endereco);
    }

    @GetMapping(URL + "/{id}")
    private Endereco procurarPorID(@PathVariable Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    private Endereco find(@RequestBody Endereco endereco) {
        return super.findById(endereco.getId());
    }

    @Override
    public void validate(Endereco entity) throws Exception {
        if (entity.getCidade() == null || entity.getCidade().isEmpty()) {
            throw new Exception("Cidade não pode ser vazia!");
        }
        if (entity.getBairro() == null || entity.getBairro().isEmpty()) {
            throw new Exception("Bairro não pode ser vazio!");

        }
        if (entity.getLogradouro() == null || entity.getLogradouro().isEmpty()) {
            throw new Exception("Logradouro não pode ser vazio!");

        }
    }
}
