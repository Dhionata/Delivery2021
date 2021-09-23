package br.com.controllers;

import br.com.entities.classes.Avaliacao;
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
    public String post() {
        Avaliacao avaliacao = new Avaliacao(5, null, "muito bom");
        System.out.println(avaliacao.toString());
        //repository.save(avaliacao);
        return avaliacao.toString();
    }
}
