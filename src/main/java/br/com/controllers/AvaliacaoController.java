package br.com.controllers;

import br.com.model.entities.classes.Avaliacao;
import br.com.model.entities.classes.Pedido;
import br.com.repository.AvaliacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository repository;

    @RequestMapping(value = "/avaliacao/teste", method = RequestMethod.GET)
    public Iterable<Avaliacao> post() {
        repository.save(new Avaliacao(5, null, "muito bom"));
        return repository.findAll();
    }
}