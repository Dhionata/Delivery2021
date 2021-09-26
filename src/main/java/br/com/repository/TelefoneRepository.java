package br.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.Telefone.Telefone;

@Repository
public interface TelefoneRepository extends CrudRepository<Telefone, Integer> {

}
