package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Services.GenericService;
import br.com.model.entities.classes.Fornecedor;
import br.com.repository.FornecedorRepository;

@RestController
public class FornecedorController extends GenericService<Fornecedor, FornecedorRepository> {

    private final String URL = "/fornecedor";

    @Autowired
    public FornecedorController(CrudRepository<Fornecedor, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Object findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save() {
        return super.save(new Fornecedor());
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(Fornecedor fornecedor) {
        return super.update(fornecedor);
    }

    @GetMapping(URL + "/Buscar/")
    public Fornecedor findById(Integer id) {
        return super.findById(id);
    }

}
