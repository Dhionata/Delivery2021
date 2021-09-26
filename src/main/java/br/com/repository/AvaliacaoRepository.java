package br.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.Avaliacao;

@Repository
public interface AvaliacaoRepository extends CrudRepository<Avaliacao, Integer> {

    // verificar a possibilidade!
    /* public Avaliacao findByAvaliacao(Avaliacao avaliacao); */
}
