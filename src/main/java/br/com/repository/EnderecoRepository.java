package br.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.Endereco.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {

}
