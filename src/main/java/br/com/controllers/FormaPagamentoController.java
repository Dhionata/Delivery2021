package br.com.controllers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.model.entities.classes.FormaPagamento;
import br.com.repository.FormaPagamentoRepository;

@RestController
public class FormaPagamentoController extends GenericController<FormaPagamento, FormaPagamentoRepository> {
    private final String URL = "/formasDePagamento";

    public FormaPagamentoController(CrudRepository<FormaPagamento, FormaPagamentoRepository> repository) {
        super(repository);
    }

    @RequestMapping(value = URL, method = RequestMethod.GET)
    public Object findAll() {
        return super.findAll();
    }
}
