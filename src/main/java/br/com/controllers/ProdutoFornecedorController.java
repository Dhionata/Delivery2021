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
import br.com.model.entities.classes.ProdutoFornecedor;
import br.com.repository.ProdutoFornecedorRepository;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoFornecedorController extends GenericService<ProdutoFornecedor, ProdutoFornecedorRepository> {

    private final String URL = "/produtoFornecedor";

    @Autowired
    private ProdutoFornecedorController(CrudRepository<ProdutoFornecedor, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    @ResponseBody
    private Iterable<ProdutoFornecedor> procurarTodos() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/")
    private ProdutoFornecedor salvar(@RequestBody ProdutoFornecedor produtoFornecedor) throws Exception {
        return super.save(produtoFornecedor);
    }

    @DeleteMapping(URL + "/Remover/")
    private Object remover(@RequestBody ProdutoFornecedor produtoFornecedor) {
        return super.remove(produtoFornecedor);
    }

    @PatchMapping(URL + "/Atualizar/")
    private ProdutoFornecedor atualizar(@RequestBody ProdutoFornecedor produtoFornecedor) throws Exception {
        return super.save(produtoFornecedor);
    }

    @GetMapping(URL + "/BuscarById/{id}")
    private ProdutoFornecedor procurarPorID(@PathVariable Integer id) {
        return super.findById(id);
    }

    @GetMapping(URL + "/Buscar/")
    private ProdutoFornecedor find(@RequestBody ProdutoFornecedor produtoFornecedor) {
        return super.findById(produtoFornecedor.getId());
    }
}
