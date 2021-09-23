package br.com.repository;

import br.com.entities.classes.Telefone.Telefone;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends CrudRepository<Telefone, Integer> {

}
