package br.com.repository;

import br.com.entities.classes.FormaPagamento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends CrudRepository<FormaPagamento, Integer> {

}
