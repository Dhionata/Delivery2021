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
import br.com.model.entities.classes.ProdutoFornecedor;
import br.com.repository.ProdutoFornecedorRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoFornecedorController extends GenericService<ProdutoFornecedor, ProdutoFornecedorRepository> {

    private final String URL = "/produtoFornecedor";

    @Autowired
    public ProdutoFornecedorController(CrudRepository<ProdutoFornecedor, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    public Iterable<ProdutoFornecedor> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    public ProdutoFornecedor save(@RequestBody ProdutoFornecedor produtoFornecedor) throws Exception {
        return super.save(produtoFornecedor);
    }

    @DeleteMapping(URL + "/Remover/")
    public Object remove(@RequestBody ProdutoFornecedor produtoFornecedor) {
        return super.remove(produtoFornecedor);
    }

    @PatchMapping(URL + "/Atualizar/")
    public Object update(@RequestBody ProdutoFornecedor produtoFornecedor) throws Exception {
        return super.save(produtoFornecedor);
    }

    @GetMapping(URL + "/BuscarById/")
    public ProdutoFornecedor findById(@RequestBody Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    public ProdutoFornecedor find(@RequestBody ProdutoFornecedor produtoFornecedor) {
        return super.findById(produtoFornecedor.getId());
    }
}
