package br.com.controllers;

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
import br.com.model.entities.classes.Produto;
import br.com.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoController extends GenericService<Produto, ProdutoRepository> {

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

    @PostMapping(value = URL + "/Adicionar/")
    private Produto salvar(@RequestBody Produto produto) throws Exception {
        return super.save(produto);
    }

    @DeleteMapping(URL + "/Remover/")
    private Object remover(@RequestBody Produto produto) {
        return super.remove(produto);
    }

    @PatchMapping(URL + "/Atualizar/")
    private Object update(@RequestBody Produto produto) throws Exception {
        return super.save(produto);
    }

    @GetMapping(URL + "/BuscarById/")
    private Produto procurarPorID(@RequestBody Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    private Produto find(@RequestBody Produto produto) {
        return super.findById(produto.getId());
    }

}
