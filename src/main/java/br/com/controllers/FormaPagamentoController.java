package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Services.GenericService;
import br.com.model.entities.classes.FormaPagamento;
import br.com.repository.FormaPagamentoRepository;

@RestController
public class FormaPagamentoController extends GenericService<FormaPagamento, FormaPagamentoRepository> {

    private final String URL = "/formaDePagamento";

    @Autowired
    public FormaPagamentoController(CrudRepository<FormaPagamento, Integer> repository) {
        super(repository);
    }

    @GetMapping(value = URL)
    public Iterable<FormaPagamento> findAll() {
        return super.findAll();
    }

    @PostMapping(value = URL + "/Adicionar/teste")
    public Object save() {
        return super.save(new FormaPagamento("Forma Teste"));
    }

    @DeleteMapping(URL + "/Remover/teste")
    public Object remove(Integer id) {
        return super.remove(id);
    }

    @PatchMapping(URL + "/Atualizar/teste")
    public Object update(FormaPagamento formaPagamento) {
        return super.update(formaPagamento);
    }

    @GetMapping(URL + "/Buscar/")
    public FormaPagamento findById(Integer id) {
        return super.findById(id);
    }

}
