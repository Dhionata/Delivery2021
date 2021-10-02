package br.com.controllers.Telefone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.Services.GenericService;
import br.com.model.entities.classes.Telefone.TelefoneFornecedor;
import br.com.repository.TelefoneFornecedorRepository;

public class TelefoneFornecedorController extends GenericService<TelefoneFornecedor, TelefoneFornecedorRepository> {
    private final String URL = "/telefoneFornecedor";

    @Autowired
    public TelefoneFornecedorController(CrudRepository<TelefoneFornecedor, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Object findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save() {
        return super.save(new TelefoneFornecedor());
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(TelefoneFornecedor telefoneFornecedor) {
        return super.update(telefoneFornecedor);
    }

    @GetMapping(URL + "/Buscar{id}")
    public Object findById(Integer id) {
        return super.findById(id);
    }
}