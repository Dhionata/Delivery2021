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
import br.com.model.entities.classes.Produto;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoController extends GenericService<Produto, Integer> {

    private final String URL = "/produto";

    @Autowired
    private ProdutoController(CrudRepository<Produto, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    private Iterable<Produto> procurarTodos() {
        return super.findAll();
    }

    @PostMapping(value = URL)
    private Produto salvar(@RequestBody Produto produto) throws Exception {
        System.out.println("\n\n-- Entrou para salvar! --\n\n" + produto.toString() + "\n\n\n");
        return super.save(produto);
    }

    @DeleteMapping(URL)
    // TODO verificar retorno, não está funcionando quando Object ou String
    private void remover(@RequestBody Produto produto) throws Exception {
        System.out.println("\n\n-- Entrou para remover! --\n\n" + produto.toString() + "\n\n\n");
        super.remove(produto);
    }

    @PatchMapping(URL)
    private Produto atualizar(@RequestBody Produto produto) throws Exception {
        System.out.println("\n\n\n-- Entrou no Atualizar --\n\n" + produto.toString() + "\n\n");
        return super.save(produto);
    }

    @GetMapping(URL + "/{id}")
    private Produto procurarPorID(@PathVariable Integer id) {
        System.out.println("\n\n-- Entrou para procurarPorID\nID: ! --\n\n" + id + "\n\n\n");
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    private Produto find(@RequestBody Produto produto) {
        System.out.println("\n\n-- Entrou para procurar! --\n\n" + produto.toString() + "\n\n\n");
        return super.findById(produto.getId());
    }

    @Override
    public void validate(Produto entity) throws Exception {
        // TODO Auto-generated method stub

    }
}