package br.com.repository.Telefone;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.model.entities.classes.telefone.Telefone;

@Repository
public interface TelefoneRepository extends CrudRepository<Telefone, Integer> {

}
