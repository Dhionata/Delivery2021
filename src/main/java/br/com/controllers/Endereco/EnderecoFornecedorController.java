package br.com.controllers.Endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.Services.GenericService;
import br.com.model.entities.classes.Endereco.EnderecoFornecedor;
import br.com.repository.EnderecoFornecedorRepository;

public class EnderecoFornecedorController extends GenericService<EnderecoFornecedor, EnderecoFornecedorRepository> {
    private final String URL = "/enderecoFornecedor";

    @Autowired
    public EnderecoFornecedorController(CrudRepository<EnderecoFornecedor, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Object findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save() {
        return super.save(new EnderecoFornecedor());
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(EnderecoFornecedor enderecoFornecedor) {
        return super.update(enderecoFornecedor);
    }

    @GetMapping(URL + "/Buscar{id}")
    public Object findById(Integer id) {
        return super.findById(id);
    }
}
