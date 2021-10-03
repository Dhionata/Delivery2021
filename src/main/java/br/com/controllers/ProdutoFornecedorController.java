package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Services.GenericService;
import br.com.model.entities.classes.ProdutoFornecedor;
import br.com.repository.ProdutoFornecedorRepository;

@RestController
public class ProdutoFornecedorController extends GenericService<ProdutoFornecedor, ProdutoFornecedorRepository> {

    private final String URL = "/produtoFornecedor";

    @Autowired
    public ProdutoFornecedorController(CrudRepository<ProdutoFornecedor, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Iterable<ProdutoFornecedor> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save() {
        return super.save(new ProdutoFornecedor());
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(ProdutoFornecedor produtoFornecedor) {
        return super.update(produtoFornecedor);
    }

    @GetMapping(URL + "/Buscar/")
    public ProdutoFornecedor findById(Integer id) {
        return super.findById(id);
    }
}
