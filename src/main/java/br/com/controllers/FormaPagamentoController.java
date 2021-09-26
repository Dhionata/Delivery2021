package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.model.entities.classes.FormaPagamento;
import br.com.repository.FormaPagamentoRepository;

@RestController
public class FormaPagamentoController {
    @Autowired
    private FormaPagamentoRepository repository;

    @RequestMapping(value = "/formaDePagamento", method = RequestMethod.GET)
    public Iterable<FormaPagamento> formaDePagamento() {
        repository.save(new FormaPagamento("Débito"));
        repository.save(new FormaPagamento("Fiado"));
        System.out.println("\nTem quantas coisas no repositório??\n" + repository.count());
        return repository.findAll();
    }
}
