package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Services.GenericService;
import br.com.model.entities.classes.Produto;
import br.com.repository.ProdutoRepository;

@RestController
public class ProdutoController extends GenericService<Produto, ProdutoRepository> {

    private final String URL = "/produto";

    @Autowired
    public ProdutoController(CrudRepository<Produto, Integer> repository) {
        super(repository);

    }

    @GetMapping(value = URL)
    public Object findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save() {
        return super.save(new Produto("Produto Teste"));
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(Produto produto) {
        return super.update(produto);
    }

    @GetMapping(URL + "/Buscar/")
    public Produto findById(Integer id) {
        return super.findById(id);
    }

}
